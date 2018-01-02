package com.xiaoshabao.vkan.mapper;

import java.util.List;

import com.xiaoshabao.vkan.entity.ProjectEntity;

public interface ProjectMapper {
	
	int insert(ProjectEntity project);
	
	ProjectEntity getProjectEntity(ProjectEntity project);
	
	List<ProjectEntity> getProjectEntityList(ProjectEntity project);
	
	List<String> getProjectPrefixList();

}
