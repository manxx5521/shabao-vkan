package com.xiaoshabao.vkan.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoshabao.vkan.custom.AjaxResult;
import com.xiaoshabao.vkan.dto.TagDto;
import com.xiaoshabao.vkan.entity.TagEntity;
import com.xiaoshabao.vkan.service.TagService;

@Controller
@RequestMapping("/vkan")
public class TagController {
	@Resource(name = "tagServiceImpl")
	private TagService tagService;

	@RequestMapping("/tagView")
	public ModelAndView getTagView(ModelMap model,@RequestParam Long fileId,Integer type) {
		if(type==null) {
			type=1;
		}
		model.put("fileId", fileId);
		model.put("type", type);
		return new ModelAndView("/vkan/tagselect", model);
	}
	
	/**
	 * 获得标签数据
	 * @return
	 */
	@RequestMapping("/tagList")
	@ResponseBody
	public List<TagEntity> getTagList(Integer parentId){
		return this.tagService.getTagList(parentId);
	}
	
	/**
	 * 获得标签数据
	 * @return
	 */
	@RequestMapping("/tag/getlabelTag")
	@ResponseBody
	public List<TagEntity> getlabelTag(@RequestParam Long fileId){
		return this.tagService.getlabelTag(fileId);
	}
	
	/**
	 * 获得标签数据
	 * @return
	 */
	@RequestMapping("/getTagListByFile")
	@ResponseBody
	public List<TagDto> getTagListByFile(@RequestParam Long fileId){
		return this.tagService.getTagListByFile(fileId);
	}
	
	/**
	 * 保存当前项标签
	 * @param fileId
	 * @param tagIds
	 * @return
	 */
	@RequestMapping(value = "/saveTag")
	@ResponseBody
	public AjaxResult saveTag(@RequestParam Long fileId,@RequestParam(name="tagIds[]",required=false) Integer[] tagIds) {
		this.tagService.saveTag(fileId, tagIds);
		return new AjaxResult(true,"保存成功");
	}
	
	/**
	 * 保存子项标签
	 * @param fileId
	 * @param tagIds
	 * @param type 1保存，2删除
	 * @return
	 */
	@RequestMapping(value = "/saveChildTag")
	@ResponseBody
	public AjaxResult saveChildTag(@RequestParam Long fileId,@RequestParam(name="tagIds[]",required=false) Integer[] tagIds
			,@RequestParam Integer type) {
		if(tagIds==null||tagIds.length<1) {
			return new AjaxResult("未选择对应的标签");
		}
		this.tagService.saveChildTag(fileId, tagIds,type);
		return new AjaxResult(true,"保存成功");
	}
	
	@RequestMapping(value = "/setTag/{id}/parentId")
	@ResponseBody
	public boolean setTagByParentId(@PathVariable("id") Long parentId) {
		return true;
	}
	
	

}
