package com.xiaoshabao.vkan.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoshabao.vkan.custom.AjaxResult;
import com.xiaoshabao.vkan.entity.FileEntity;
import com.xiaoshabao.vkan.entity.ProjectEntity;
import com.xiaoshabao.vkan.enums.FileType;
import com.xiaoshabao.vkan.enums.ReaderFileType;
import com.xiaoshabao.vkan.exception.MsgErrorException;
import com.xiaoshabao.vkan.mapper.FileMapper;
import com.xiaoshabao.vkan.mapper.ProjectMapper;
import com.xiaoshabao.vkan.service.FileManagerService;
import com.xiaoshabao.vkan.util.CmdUtil;
import com.xiaoshabao.vkan.util.SnowflakeUtil;

@Service("fileManagerServiceImpl")
public class FileManagerServiceImpl implements FileManagerService {
	
	private final static Logger logger = LoggerFactory.getLogger(FileManagerServiceImpl.class);
	
	@Autowired
	private FileMapper fileMapper;
	@Autowired
	private ProjectMapper projectMapper;

	// 新增项目
	@Override
	@Transactional
	public AjaxResult addProject(String projectName, String filePath) {
		if (!filePath.endsWith(File.separator)) {
			filePath = filePath + File.separator;
		}
		File file = new File(filePath);
		if (!file.isDirectory()) {
			throw new MsgErrorException("添加项目时错误，父级目录不是文件夹！");
		}
		// 统一名字
		filePath = file.getAbsolutePath();
		if (!filePath.endsWith(File.separator)) {
			filePath = filePath + File.separator;
		}
		String prefix = FilenameUtils.getPrefix(filePath);
		String path = FilenameUtils.getPath(filePath);

		ProjectEntity project = new ProjectEntity();
		project.setProjectName(projectName);
		project.setProjectPrefix(prefix);
		project.setProjectPath(path);
		/*
		ProjectEntity temp=this.baseDao.getDataSingle(ProjectEntity.class, project);
		if(temp!=null) {
			throw new MsgErrorException("当前项目已经存在");
		}*/
		int i = this.projectMapper.insert(project);
		Integer projectId = project.getProjectId();
		if (i < 1 || projectId == null) {
			throw new MsgErrorException("项目信息插入失败");
		}

		readParserFiles(project, projectId.longValue(), file, ReaderFileType.ADD);
		return new AjaxResult(true,"导入项目成功！");
	}
	
	//打开文件
	@Override
	public AjaxResult openFile(Long fileId, String prefixPath, Integer type) {
		String path=getFilePahtById(fileId, prefixPath);
		
		//上级目录
//		path=path.substring(0, path.lastIndexOf(File.separator));
		
		try {
			//如果是文件夹取上级目录
			if(type==1) {
				CmdUtil.openFile(path);
			}else{
				CmdUtil.openFileDir(path);
			}
		} catch (Exception e) {
			logger.error("打开文件执行cmd错误：",e);
			return new AjaxResult("打开文件执行cmd错误");
		}
		
		return new AjaxResult(true,"成功");
	}
	
	/**
	 * 获得实际目录
	 * @param fileId
	 * @param prefixPath
	 * @return
	 */
	private String getFilePahtById(Long fileId, String prefixPath) {
		FileEntity fileReq=new FileEntity();
		fileReq.setFileId(fileId);
		FileEntity file=this.fileMapper.getFileEntity(fileReq);
		if(file==null) {
			throw new MsgErrorException("未能根据id找到对应文件");
		}
		
		ProjectEntity projectReq=new ProjectEntity();
		projectReq.setProjectId(file.getProjectId());
		ProjectEntity project=this.projectMapper.getProjectEntity( projectReq);
		if(project==null) {
			throw new MsgErrorException("未能根据id找到对应项目");
		}
		
		return prefixPath+project.getProjectPath()+file.getPath();
	}
	
	/**
	 * 设置成视频目录
	 * @param prarentId
	 */
	public void setVideoProject(Long prarentId,String prefixPath) {
//		String path =this.getFilePahtById(prarentId, prefixPath);
		
		
	}
	
	//设置封面
	@Override
	@Transactional
	public AjaxResult setFileCover(Long fileId) {
		FileEntity fileReq=new FileEntity();
		fileReq.setFileId(fileId);
		FileEntity fileEntity=this.fileMapper.getFileEntity(fileReq);
		if(fileEntity==null) {
			return new AjaxResult("失败：当前文件id错误");
		}
		
		FileEntity fileUpdate=new FileEntity();
		fileUpdate.setFileId(fileEntity.getParentId());
		fileUpdate.setCoverId(fileId);
		int i=this.fileMapper.update( fileUpdate);
		if(i<1) {
			return new AjaxResult("失败：未能找到上级目录");
		}
		return new AjaxResult(true,"设置成功");
	}

	
	/**
	 * 读取文件入口-递归解析文件
	 * 
	 * @param projectId
	 * @param parentFile
	 * @param parentId
	 */
	private void readParserFiles(ProjectEntity project, Long parentId, File parentFile, ReaderFileType type) {
		File[] files = parentFile.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				operFile(project, file, true, parentId, type);
			} else if (file.isDirectory()) {
				Long fileId = operFile(project, file, false, parentId, type);
				readParserFiles(project, fileId, file, type);
			}
		}
	}

	/**
	 * 根据不同的操作，进行文件处理
	 * 
	 * @param file
	 * @param isFile
	 *            是否是文件
	 * @param parentId
	 * @return
	 */
	private Long operFile(ProjectEntity project, File file, boolean isFile, Long parentId, ReaderFileType type) {
		FileEntity fileEntity = new FileEntity();
		String fileName = file.getName();
		String path = file.getAbsolutePath();
		path=path.replace(project.getProjectPrefix() + project.getProjectPath(), "");
		fileEntity.setProjectId(project.getProjectId());
		fileEntity.setFileName(fileName);
		fileEntity.setPath(path);
		
		switch (type) {
		case UPDATE:
			//如果存在 跳出
			FileEntity temp=this.fileMapper.getFileEntity( fileEntity);
			if(temp!=null&&temp.getFileId()!=null) {
				return temp.getFileId();
			}
		case ADD:
			String md5 = null;
			int fileTypeCode = 9;
			if (isFile) {
				try (InputStream inputStream = new FileInputStream(file)) {
					md5 = DigestUtils.md5Hex(inputStream);
				} catch (IOException e) {
					logger.error("记录文件{}时出现错误", path, e);
				}
				fileTypeCode = FileType.getCodeByName(file.getName());
			} else {
				fileTypeCode = FileType.DIRECTORY.getCode();
			}
			
			long fileId = SnowflakeUtil.nextId();
			fileEntity.setFileId(fileId);
			fileEntity.setMd5(md5);
			fileEntity.setFileType(fileTypeCode);
			fileEntity.setParentId(parentId);

			this.fileMapper.insert(fileEntity);
			return fileId;
		default:
			throw new MsgErrorException("读取类型错误");
		}
	}
	
	@Override
	public FileEntity getFileEntity(FileEntity fileEntity) {
		return this.fileMapper.getFileEntity(fileEntity);
	}



}
