package com.xiaoshabao.vkan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiaoshabao.vkan.dto.TagDto;
import com.xiaoshabao.vkan.entity.TagEntity;

public interface TagMapper {
	
	TagEntity getTagEntity(TagEntity tagEntity);
	
	List<TagEntity> getTagEntityList(TagEntity tagEntity);
	
	List<TagEntity> getlabelTag(@Param("fileId")Long fileId);
	
	List<TagDto> getTagDtoList(@Param("fileId")Long fileId);


}
