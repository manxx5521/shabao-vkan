package com.xiaoshabao.vkan.service;

import java.util.List;

import com.xiaoshabao.vkan.dto.TagDto;
import com.xiaoshabao.vkan.entity.TagEntity;

public interface TagService {

	/**
	 * 查询tag标签
	 * @param parentId
	 * @return
	 */
	List<TagEntity> getTagList(Integer parentId);
	
	/**
	 * 查询tag标签
	 * @param parentId
	 * @return
	 */
	List<TagEntity> getlabelTag(Long fileId);
	
	/**
	 * 查询tag标签
	 * @return
	 */
	List<TagDto> getTagListByFile(Long fileId);
	

	/**
	 * 保存标签
	 * @param ids
	 */
	void saveTag(Long fileId,Integer[] tagIds);
	
	/**
	 * 保存子项标签
	 * @param fileId
	 * @param tagIds
	 * @param type 1保存，2删除
	 */
	void saveChildTag(Long fileId,Integer[] tagIds,Integer type);
	

}
