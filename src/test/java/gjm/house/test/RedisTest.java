package gjm.house.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gjm.house.common.util.RedisUtil;

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
	public void test() {
		
	}

}
