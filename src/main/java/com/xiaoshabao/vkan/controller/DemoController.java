package com.xiaoshabao.vkan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoshabao.vkan.entity.DemoEntity;
import com.xiaoshabao.vkan.service.DemoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * demo
 * <p>
 * Swagger2测试界面访问 http://localhost:8080/swagger-ui.html <br>
 * 注解使用@ApiOperation<br>
 * 		body 使用@RequestBody接收数据 POST有效<br>
 *		path 在url中配置{}的参数<br>
 *		query 普通查询参数 例如 ?query=q ,jquery ajax中data设置的值也可以，例如 {query:”q”},springMVC中不需要添加注解接收<br>
 *		header 使用@RequestHeader接收数据<br>
 *		form 笔者未使用，请查看官方API文档<br>
 * </p>
 */
@Api(value = "演示controller", tags = { "演示界面" })
@RestController
@RequestMapping(value = "/demo")
public class DemoController {
	@Autowired
	private DemoService demoService;

	// 缓存管理
	@Autowired
	private CacheManager cacheManager;

	@ApiOperation(value = "获取demo列表界面", notes = "本接口直接返回html界面")
	@GetMapping
	public ModelAndView getList(@ApiIgnore() ModelMap model) {
		model.put("title", "演示界面");
		model.put("data", demoService.getDemoList());
		return new ModelAndView("demo", model);
	}

	@ApiOperation(value = "获取demo详细信息", notes = "根据url的id来获取demo详细信息")
	@ApiImplicitParam(name = "id", value = "demo的ID", required = true, paramType = "path", dataType = "Integer")
	@GetMapping("/{id}")
	public DemoEntity getDemoEntity(@PathVariable("id") Integer id) {
		DemoEntity demo = new DemoEntity();
		demo.setName("测试信息");
		return demo;
	}

	@ApiOperation(value = "新增demo", notes = "新增")
	@ApiImplicitParam(name = "demoEntity", value = "demo是实体", required = true, dataType = "DemoEntity")
	@PostMapping
	public boolean add(DemoEntity demoEntity) {
		return demoService.insert(demoEntity);
	}

	@ApiOperation(value = "更新demo实体", notes = "更新")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "demo的id", required = true,paramType = "path", dataType = "Integer"),
			@ApiImplicitParam(name = "demoEntity", value = "demo详细实体", required = true, dataType = "DemoEntity") })
	@PutMapping("/{id}")
	public boolean update(@PathVariable("id") Integer id, DemoEntity demoEntity) {
		// 返回测试信息
		return true;
	}

	@ApiOperation(value = "删除demo实体", notes = "根据url的id来指定删除对象")
	@ApiImplicitParam(name = "id", value = "demo的ID", required = true,paramType = "path", dataType = "Integer")
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable("id") Integer id) {
		// 测试数据
		return true;
	}

	/**
	 * 清空现有缓存
	 * <p>
	 * 存储缓存在 DemoMapper里
	 * </p>
	 * 
	 * @return
	 */
	@ApiIgnore // 使用该注解忽略这个API Swagger2
	@RequestMapping(value = "/rmcache", method = RequestMethod.GET)
	public boolean clearCache() {
		cacheManager.getCache("baseCache").clear();
		return true;
	}
}
