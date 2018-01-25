package redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.xiaoshabao.vkan.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@WebAppConfiguration
public class RedisTest {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Test
	public void test() throws Exception {
		ValueOperations<String, String> vo = redisTemplate.opsForValue();
		vo.set("test", "1111");
		
		System.out.println("-----------------------"+vo.get("test"));
	}

}
