package com.xiaoshabao.vkan.mapper;

import java.util.Map;

import com.xiaoshabao.vkan.entity.FileTagEntity;

public interface FileTagMapper {
	
	int delete(FileTagEntity fileTag);
	
	int insertTagByListId(Map<String, Object> params);
	
	int insertTagByParentId(Map<String, Object> params);
	
	int deleteTagByParentId(Map<String, Object> params);
	
	

}
