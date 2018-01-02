package com.xiaoshabao.vkan.entity;
/**
 * 标签
 */
public class TagEntity {
	private Integer tagId;
	private String name;
	private String icon;
	private Integer type;
	private Integer level;
	private Integer parentId;
	/**标签是否可以多选，1级有效*/
	private Boolean multiple;
	
	/**是否在文件列表展现*/
	private Boolean fileShow;
	/**文件列表展现顺序*/
	private Integer fileOrder;
	
	private Boolean used;
	private Integer orderNo;
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Boolean getUsed() {
		return used;
	}
	public void setUsed(Boolean used) {
		this.used = used;
	}
	public Boolean getFileShow() {
		return fileShow;
	}
	public void setFileShow(Boolean fileShow) {
		this.fileShow = fileShow;
	}
	public Boolean getMultiple() {
		return multiple;
	}
	public void setMultiple(Boolean multiple) {
		this.multiple = multiple;
	}
	public Integer getFileOrder() {
		return fileOrder;
	}
	public void setFileOrder(Integer fileOrder) {
		this.fileOrder = fileOrder;
	}
	
}
