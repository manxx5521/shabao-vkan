package com.xiaoshabao.vkan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiaoshabao.vkan.dto.FileDto;
import com.xiaoshabao.vkan.dto.FilePagingParams;
import com.xiaoshabao.vkan.entity.FileEntity;

public interface FileMapper {
	
	int insert(FileEntity project);
	
	int update(FileEntity project);
	

	FileEntity getFileEntity(FileEntity file);
	
	FileEntity getFileEntityById(@Param("id")Long fileId);
	
	List<FileDto> getPageFileDto(FilePagingParams params);
}
