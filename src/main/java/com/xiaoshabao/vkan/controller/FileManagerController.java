package com.xiaoshabao.vkan.controller;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.xiaoshabao.vkan.custom.AjaxResult;
import com.xiaoshabao.vkan.entity.FileEntity;
import com.xiaoshabao.vkan.service.FileManagerService;
/**
 * 文件管理
 */
@Controller
@RequestMapping(value="/vkan/file")
public class FileManagerController{
	@Resource(name="fileManagerServiceImpl")
	private FileManagerService fileService;
	
	/**
	 * 插入项目文件
	 * @param projectName
	 * @param filePath
	 * @return
	 */
	@RequestMapping(value="/insert")
	@ResponseBody
	public AjaxResult addProject (String projectName,String filePath){
		if(StringUtils.isEmpty(projectName)||StringUtils.isEmpty(filePath)) {
			return new AjaxResult("项目名或项目路径不能为空");
		}
		return fileService.addProject(projectName, filePath);
	}
	

	/**
	 * 打开文件
	 * @param fileId
	 * @param prefixPath
	 * @param type 1打开文件，2文件夹
	 * @return
	 */
	@RequestMapping(value="/openFile")
	@ResponseBody
	public AjaxResult openFile(@RequestParam@JsonSerialize(using=ToStringSerializer.class) Long fileId,@RequestParam String prefixPath,@RequestParam Integer type) {
		
		return this.fileService.openFile(fileId, prefixPath, type);
	}
	
	
	/**
	 * 设置为封面
	 * @param fileId
	 * @param projectTag
	 * @return
	 */
	@RequestMapping(value="/setFileCover")
	@ResponseBody
	public AjaxResult setFileCover(@RequestParam@JsonSerialize(using=ToStringSerializer.class) Long fileId) {
		return this.fileService.setFileCover(fileId);
	}
	
	/**
	 * 根据父级文件内容
	 * @param fileId
	 * @return
	 */
	@RequestMapping("/getParentFile")
	@ResponseBody
	public AjaxResult getParentFile(@RequestParam("id")@JsonSerialize(using=ToStringSerializer.class) Long fileId) {
		FileEntity req=new FileEntity();
		req.setFileId(fileId);
		FileEntity fileEntity=this.fileService.getFileEntity(req);
		if(fileEntity!=null) {
			return new AjaxResult(true,fileEntity);
		}
		return new AjaxResult("未能正常获得数据");
		
	}

}
