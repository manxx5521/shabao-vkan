package com.xiaoshabao.vkan.service;

import com.xiaoshabao.vkan.custom.AjaxResult;
import com.xiaoshabao.vkan.entity.FileEntity;

public interface FileManagerService{

	/**
	 * 新增项目
	 * @param projectName 测试项目
	 * @param filePath E:\test\test
	 * @return
	 */
	AjaxResult addProject(String projectName, String filePath);
	
	/**
	 * 打开文件
	 * @param fileId
	 * @param prefixPath
	 * @param type type 1打开文件，2文件夹
	 * @return
	 */
	AjaxResult openFile(Long fileId,String prefixPath, Integer type);
	
	/**
	 * 设置成视频目录
	 * @param prarentId
	 */
	public void setVideoProject(Long parentId,String prefixPath);
	
	/**
	 * 更新文件
	 * @param prarentId
	 * @param prefixPath
	 */
	public  void updateFiles(Long parentId,String prefixPath);
	/**
	 * 设置封面
	 * @param fileId
	 * @return
	 */
	AjaxResult setFileCover(Long fileId);

	/**
	 * 获得文件
	 * @param fileEntity
	 * @return
	 */
	FileEntity getFileEntity(FileEntity fileEntity) ;

}
