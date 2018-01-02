package com.xiaoshabao.vkan.entity;

/**
 * 标签关系
 */
public class FileTagEntity {
	
	private Integer id;
	private Long fileId;
	private Integer tagId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getFileId() {
		return fileId;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	
}
