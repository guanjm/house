package gjm.house.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gjm.house.demo.dao.ITestDao;
import gjm.house.demo.entity.TbTest;

/**
 * 缓存测试用例
 * @author Tim
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EhcacheTest {
	
	@Resource
	private ITestDao testDao;
	
	@Test
	public void test() throws InterruptedException {
		System.out.println("------------ehcacheTest_start-------------");
		TbTest test = new TbTest();
		test.setId(1);
		/*缓存数据*/
		testDao.Cacheable(1);
		/*更新缓存*/
		test.setValue("CachePut");
		test = testDao.CachePut(test);
		System.out.println(test.getValue());
		testDao.Cacheable(1);
		System.out.println(test.getValue());
		/*清除缓存*/
		test.setValue("CacheEvict");
		test = testDao.CacheEvict(test);
		System.out.println(test.getValue());
		testDao.Cacheable(1);
		System.out.println(test.getValue());
		System.out.println("------------ehcacheTest_end-------------");
	}

}
