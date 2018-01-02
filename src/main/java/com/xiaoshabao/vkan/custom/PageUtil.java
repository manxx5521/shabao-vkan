package com.xiaoshabao.vkan.custom;

import com.github.pagehelper.PageHelper;

/**
 * 分页工具类
 *
 */
public class PageUtil {

	/**
	 * 分页方法
	 * <p>
	 * 如果想直接返回列表直接在mapper方法中返回List<UserInfo><br>
	 * 如果想要返回分页参数在mapper中返回Page<UserInfo>形式参数
	 * </p>
	 * @param pageParams
	 */
	public static void startPage(PageParams pageParams) {
		if (pageParams.getPage() != null && pageParams.getRows() != null) {
			PageHelper.startPage(pageParams.getPage(), pageParams.getRows());
		}
	}

	/**
	 * 分页方法
	 * <p>
	 * 如果想直接返回列表直接在mapper方法中返回List<UserInfo><br>
	 * 如果想要返回分页参数在mapper中返回Page<UserInfo>形式参数
	 * </p>
	 * @param pageParams
	 */
	public static void startPage(Integer page, Integer rows) {
		if (page != null && rows != null) {
			PageHelper.startPage(page, rows);
		}
	}

}
