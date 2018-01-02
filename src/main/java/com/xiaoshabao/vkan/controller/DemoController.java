package com.xiaoshabao.vkan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoshabao.vkan.entity.DemoEntity;
import com.xiaoshabao.vkan.service.DemoService;

@RestController
@RequestMapping(value="/demo")
public class DemoController {
	@Autowired
	private DemoService demoService;
	
	//缓存管理
	@Autowired
	private CacheManager cacheManager;
	
	@RequestMapping(value="/list")
	public ModelAndView list(ModelMap model) {
		model.put("title", "演示界面");
		model.put("data", demoService.getDemoList());
		return new ModelAndView("demo",model);
	}

	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public boolean add(DemoEntity demoEntity) {
		return demoService.insert(demoEntity);
	}
	
	/**
	 * 清空现有缓存
	 * <p>存储缓存在 DemoMapper里</p>
	 * @return
	 */
	@RequestMapping(value="/rmcache",method=RequestMethod.GET)
	public boolean clearCache() {
		cacheManager.getCache("baseCache").clear();
		return true;
	}
}
