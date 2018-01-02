package com.xiaoshabao.vkan.dto;
/**
 * 主页传值对象
 */
public class IndexDataVo {
	/**项目选择的磁盘*/
	private String projectPrefix;
	/**项目选择的项目id*/
	private Integer projectId;
	
	/**优先级最高，直接请求父级目录*/
	private Long parentId;

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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
}
