package com.xiaoshabao.vkan.custom;

/**
 * 分页参数
 */
public class PageParams {

	/** 第几页 */
	private Integer page = 1;
	/** 多少行 */
	private Integer rows = 10;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
}
