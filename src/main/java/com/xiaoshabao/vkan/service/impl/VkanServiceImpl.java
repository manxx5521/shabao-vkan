package com.xiaoshabao.vkan.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoshabao.vkan.custom.PageParams;
import com.xiaoshabao.vkan.custom.PageUtil;
import com.xiaoshabao.vkan.dto.FileDto;
import com.xiaoshabao.vkan.dto.FilePagingParams;
import com.xiaoshabao.vkan.dto.IndexDataVo;
import com.xiaoshabao.vkan.dto.VkanIndexDto;
import com.xiaoshabao.vkan.entity.FileEntity;
import com.xiaoshabao.vkan.entity.ProjectEntity;
import com.xiaoshabao.vkan.entity.TagEntity;
import com.xiaoshabao.vkan.enums.FileType;
import com.xiaoshabao.vkan.mapper.FileMapper;
import com.xiaoshabao.vkan.mapper.ProjectMapper;
import com.xiaoshabao.vkan.mapper.TagMapper;
import com.xiaoshabao.vkan.service.VkanService;

@Service("vkanServiceImpl")
public class VkanServiceImpl implements VkanService {
	@Autowired
	private FileMapper fileMapper;
	@Autowired
	private ProjectMapper projectMapper;
	@Autowired
	private TagMapper tagMapper;
	@Override
	public VkanIndexDto getIndexData(IndexDataVo indexData) {
		VkanIndexDto result = new VkanIndexDto();

		// 如果传入父级id
		if (indexData.getParentId() != null) {
			FileEntity req = new FileEntity();
			req.setFileId(indexData.getParentId());
			FileEntity fileEntity = this.fileMapper.getFileEntity(req);
			if (fileEntity != null) {
				ProjectEntity projectReq = new ProjectEntity();
				projectReq.setProjectId(fileEntity.getProjectId());
				ProjectEntity projectEntity = this.projectMapper.getProjectEntity( projectReq);
				if (projectEntity != null) {
					// 所有信息都能查到
					String prefix=indexData.getProjectPrefix();
					if(StringUtils.isEmpty(prefix)) {
						prefix=projectEntity.getProjectPrefix();
					}
					String path =prefix+  projectEntity.getProjectPath() + fileEntity.getPath();
					File file = new File(path);
					if (file != null) {
						//刷新需要的值
						indexData.setProjectPrefix(prefix);
						indexData.setProjectId(projectReq.getProjectId());
					}
				}
			}
		}

		//获取主页数据
		ProjectEntity projectReq=new ProjectEntity();
		List<ProjectEntity> projects = this.projectMapper.getProjectEntityList(projectReq);
		result.setProjectList(projects);

		List<String> prefixs = this.projectMapper.getProjectPrefixList();
		result.setPrefixs(prefixs);

		if (projects != null && projects.size() > 0) {
			// 是否是二次搜索
			if (indexData.getProjectId() == null) {
				result.setProjectPrefix(projects.get(0).getProjectPrefix());
				result.setProjectId(projects.get(0).getProjectId());
				result.setProjectName(projects.get(0).getProjectName());
				result.setProjectPath(projects.get(0).getProjectPath());
				result.setParentId(indexData.getParentId()==null?Long.valueOf(projects.get(0).getProjectId()):indexData.getParentId());
			} else {
				for (ProjectEntity project : projects) {
					if (project.getProjectId().equals(indexData.getProjectId())) {
						result.setProjectPrefix(project.getProjectPrefix());
						result.setProjectId(project.getProjectId());
						result.setProjectName(project.getProjectName());
						result.setProjectPath(project.getProjectPath());
						result.setParentId(indexData.getParentId()==null?Long.valueOf(project.getProjectId()):indexData.getParentId());
					}
				}
			}

		}
		return result;
	}

	@Override
	public List<FileDto> getFileDto(FilePagingParams params,PageParams pageParams) {
		PageUtil.startPage(pageParams);
		List<FileDto> list = this.fileMapper.getPageFileDto( params);
		if (list != null) {
			for (FileDto fileDto : list) {
				//标签
				List<TagEntity> tagList = this.tagMapper.getlabelTag(fileDto.getFileId());
				fileDto.setTagList(tagList);
				
				//设置封面
				String coverId=fileDto.getCoverId();
				if(coverId!=null&&fileDto.getFileType()!=FileType.IMAGE.getCode()) {
					String[] covers=coverId.split(",");
					List<String> coverList=new ArrayList<String>(covers.length);
					for(String id:covers) {
						FileEntity coverReq=new FileEntity();
						coverReq.setFileId(Long.valueOf(id));
						FileEntity cover=this.fileMapper.getFileEntity(coverReq);
						if(cover!=null&&cover.getPath()!=null) {
							coverList.add(cover.getPath());
						}
					}
					fileDto.setCoverList(coverList);
				}
			}
		}

		return list;
	}
	
}
