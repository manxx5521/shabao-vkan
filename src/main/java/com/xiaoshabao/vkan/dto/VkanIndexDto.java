package com.xiaoshabao.vkan.dto;

import java.util.List;

import com.xiaoshabao.vkan.entity.ProjectEntity;

public class VkanIndexDto {

	private List<ProjectEntity> projectList;

	private List<String> prefixs;

	private String projectPrefix;

	private Integer projectId;
	
	private String projectName;
	
	private String projectPath;
	
	/**父级文件id 用于内层查询*/
	private Long parentId;

	public List<ProjectEntity> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<ProjectEntity> projectList) {
		this.projectList = projectList;
	}

	public List<String> getPrefixs() {
		return prefixs;
	}

	public void setPrefixs(List<String> prefixs) {
		this.prefixs = prefixs;
	}

	public String getProjectPrefix() {
		return projectPrefix;
	}

	public void setProjectPrefix(String projectPrefix) {
		this.projectPrefix = projectPrefix;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectPath() {
		return projectPath;
	}

	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
