package com.xiaoshabao.vkan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2配置
 * <p>使用static-path-pattern后无法找到ui界面，需要再webconfig中重新注入路径</p>
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
	
	/**
	 * 创建界面访问api
	 * @return
	 */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("页面接口")
                .apiInfo(apiInfo())
                .select()
                //需要扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.xiaoshabao.vkan.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    
    
    /**
	 * 创建api接口测试（可以创建多个开启本方法bean注解即可）
	 * @return
	*/
//    @Bean
    public Docket createApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("api接口")
                .apiInfo(apiInfo())
                .select()
                //需要扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.xiaoshabao.vkan.api"))
                .paths(PathSelectors.any())
                .build();
    } 

    /**
     * Api的基本信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("资源构建RESTful APIs")
                .description("描述项目是111")
                .termsOfServiceUrl("http://servviceurl.com/")
                .contact(new Contact("资源项目", "http://Contacturl.com/", "manxx5521@163.com"))
                .version("1.0")
                .build();
    }

}