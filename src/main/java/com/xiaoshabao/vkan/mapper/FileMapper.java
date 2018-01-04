package com.xiaoshabao.vkan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiaoshabao.vkan.dto.FileDto;
import com.xiaoshabao.vkan.dto.FilePagingParams;
import com.xiaoshabao.vkan.entity.FileEntity;

public interface FileMapper {
	
	int insert(FileEntity file);
	
	int update(FileEntity file);
	

	FileEntity getFileEntity(FileEntity file);
	
	List<FileEntity> getFileEntityList(FileEntity file);
	
	FileEntity getFileEntityById(@Param("id")Long fileId);
	
	List<FileDto> getPageFileDto(FilePagingParams params);
	
	int deleteByMd5s(@Param("md5s")List<String> md5s,@Param("parentId")Long parentId);
	int deleteByDirs(@Param("dirs")List<String> dirs,@Param("parentId")Long parentId);
}
