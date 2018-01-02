package com.xiaoshabao.vkan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 启动类
 * <p>
 * \@SpringBootApplication注解启动项目，
 * 等价于以默认属性使用@Configuration，@EnableAutoConfiguration和@ComponentScan。
 * 
 * <h2>关于扫描包</h2>
 * 启动类必须放到所有controller的父级目录里，否则扫描不到controller。<br/>
 * 或者使用@ComponentScan(basePackages="com.xiaoshabao.vkan.controller")注解指定扫描位置加载。<br>
 * \@MapperScan用来指定mabatis的扫描路径
 * 
 * <h2>项目发布</h2>
 * 项目通过插件直接发布相当于发布到ROOT目录下，无需加web-root访问
 * </p>
 */
@SpringBootApplication
//开启缓存注解
@EnableCaching 
@MapperScan(basePackages="com.xiaoshabao.**.mapper")
public class App {

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);

	}

}
