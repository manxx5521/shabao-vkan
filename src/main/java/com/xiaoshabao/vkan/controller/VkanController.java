package com.xiaoshabao.vkan.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoshabao.vkan.custom.PageParams;
import com.xiaoshabao.vkan.dto.FileDto;
import com.xiaoshabao.vkan.dto.FilePagingParams;
import com.xiaoshabao.vkan.dto.IndexDataVo;
import com.xiaoshabao.vkan.service.VkanService;

@Controller
@RequestMapping("/vkan")
public class VkanController {
	@Autowired
	private VkanService vkanService;

	@RequestMapping("/index")
	public ModelAndView getIndexData(ModelMap model,IndexDataVo indexData) {
		model.put("data", vkanService.getIndexData(indexData));
		return new ModelAndView("/vkan/index", model);
	}
	
	
	/**
	 * 获得文件数据
	 * @return
	 */
	@RequestMapping("/fileData")
	@ResponseBody
	public List<FileDto> getFileDataView(ModelMap model,@RequestParam(name="idStr",required=false) String idStr,
			FilePagingParams params,PageParams pageParams) {
		List<List<String>> tagIds=new LinkedList<List<String>>();
		if(StringUtils.isNotEmpty(idStr)) {
			String[] groups=idStr.split("\\|");
			for(String group:groups) {
				String[] ids=group.split(",");
				tagIds.add(Arrays.asList(ids));
			}
			params.setTagIds(tagIds);
		}
		
		return this.vkanService.getFileDto(params,pageParams);
	}
	
}
