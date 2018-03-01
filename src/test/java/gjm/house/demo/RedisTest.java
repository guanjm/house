package gjm.house.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gjm.house.common.util.BytesUtil;
import gjm.house.common.util.RedisUtil;
import redis.clients.jedis.Jedis;

/**
 * redis测试用例
 * @author Tim
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class RedisTest {
	
	@Resource
	private RedisUtil redisUtil;
	
	@Test
	public void test() throws InterruptedException {
		
	}

}
