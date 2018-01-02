package com.xiaoshabao.vkan.service;

import java.util.List;

import com.xiaoshabao.vkan.custom.PageParams;
import com.xiaoshabao.vkan.dto.FileDto;
import com.xiaoshabao.vkan.dto.FilePagingParams;
import com.xiaoshabao.vkan.dto.IndexDataVo;
import com.xiaoshabao.vkan.dto.VkanIndexDto;

public interface VkanService {

	/**
	 * 获得主页数据
	 * 
	 * @return
	 */
	VkanIndexDto getIndexData(IndexDataVo indexData);
	
	/**
	 * 查询文件数据
	 * @param parentId
	 * @return
	 */
	List<FileDto> getFileDto(FilePagingParams params,PageParams pageParams);

}
