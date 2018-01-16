package com.xiaoshabao.vkan.service.impl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.xiaoshabao.vkan.Application;
import com.xiaoshabao.vkan.service.FileManagerService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@WebAppConfiguration
public class FileManagerServiceImplTest {

	@Autowired
	private FileManagerService fileService;

	@Test
	public void testAddProject() {
		try {
			this.fileService.addProject("测试项目", "E:\\vm\\test\\test");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
		
	}

}
