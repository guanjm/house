package gjm.house.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import gjm.house.demo.dao.ITestDao;
import gjm.house.demo.entity.TbTest;
import gjm.house.demo.service.ITestService;

/**
 * 持久化测试用例
 * @author Tim
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestEntity {
	
	@Resource
	private ITestDao testDao;
	
	@Resource
	private ITestService testService;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testDao() {
		System.out.println("--------------testDao_start------------");
		TbTest test = new TbTest();
		test.setId(1);
		testDao.delete(test);
		System.out.println("---------------testDao_end------------");
	}
	
	@Test
	public void testService() {
		System.out.println("---------------testService_start------------");
		TbTest test = new TbTest();
		testService.save(test);
		System.out.println("---------------testService_end------------");
	}

}
