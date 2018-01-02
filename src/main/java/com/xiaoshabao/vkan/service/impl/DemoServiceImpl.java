package com.xiaoshabao.vkan.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoshabao.vkan.entity.DemoEntity;
import com.xiaoshabao.vkan.mapper.DemoMapper;
import com.xiaoshabao.vkan.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService{
	@Autowired
	private DemoMapper demoMapper;
	/*
	 * 获得全部列表
	 * @return
	 */
	@Override
	public List<DemoEntity> getDemoList() {
//		return getListByJdbc();
		return demoMapper.getList();
	}
	
	@Transactional
	@Override
	public boolean insert(DemoEntity demoEntity) {
		int i=this.demoMapper.insert(demoEntity);
		if(i>0) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	/************  SpringJDBC 查询数据演示  begin************************************************************/
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<DemoEntity> getListByJdbc() {
		List<DemoEntity> result=null;
		
		List<Map<String, Object>> list=jdbcTemplate.queryForList("select * from test_demo where 1=?", 1);
		
		if(list!=null&&!list.isEmpty()) {
			result=new ArrayList<DemoEntity>(list.size());
			for(Map<String, Object> map:list) {
				DemoEntity entity=new DemoEntity();
				entity.setId(Integer.valueOf(map.get("id").toString()));
				entity.setName(map.get("name").toString());
				
				result.add(entity);
			}
		}
		return result;
	}
	/************  SpringJDBC 查询数据演示  end************************************************************/


}
