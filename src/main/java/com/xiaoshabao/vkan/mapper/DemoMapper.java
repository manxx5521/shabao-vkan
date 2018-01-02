package com.xiaoshabao.vkan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.xiaoshabao.vkan.entity.DemoEntity;

/**
 * \@CacheConfig开启缓存
 */
@CacheConfig(cacheNames = "baseCache")
public interface DemoMapper {
	
	/**
	 * 添加
	 * @param demoEntity
	 * @return
	 */
	@Insert("insert into test_demo(id,name) values (null,#{name,jdbcType=VARCHAR})")
	int insert(DemoEntity demoEntity);
	
	@Select("select * from test_demo")
	@Cacheable
	List<DemoEntity> getList();

}
