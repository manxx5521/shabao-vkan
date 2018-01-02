package com.xiaoshabao.vkan.dto;

import com.xiaoshabao.vkan.entity.TagEntity;

public class TagDto extends TagEntity{
	
	private Boolean selected;

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	
}
