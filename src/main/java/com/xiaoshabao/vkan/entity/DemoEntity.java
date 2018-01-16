package com.xiaoshabao.vkan.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="demo实体")
public class DemoEntity {
	@ApiModelProperty(value = "主键id", example = "1001")
	private Integer id;
	@ApiModelProperty(value = "名字", example = "张三")
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
