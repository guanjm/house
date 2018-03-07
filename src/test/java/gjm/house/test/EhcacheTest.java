package gjm.house.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gjm.house.common.util.EhcacheUtil;
import gjm.house.common.util.EhcacheUtil.CacheName;
import gjm.house.demo.dao.ITestDao;
import gjm.house.demo.entity.TbTest;

/**
 * ehcache测试用例
 * @author Tim
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EhcacheTest {
	
	@Resource
	private ITestDao testDao;
	
	@Test
	public void timeTest() throws InterruptedException {
		testDao.Cacheable(1);
		System.out.println("sleep 9 s");
		Thread.sleep(9000);
		testDao.Cacheable(1);
		System.out.println("sleep 2 s");
		Thread.sleep(2000);
		testDao.Cacheable(1);
		
		/*
			期待结果：
			--------get from db--------
			sleep 9 s
			sleep 2 s
			--------get from db--------
		*/
	}
	
	@Test
	public void daoTest() {
		TbTest test;
		/*缓存数据*/
		test = testDao.Cacheable(1);
		System.out.println(test.getValue());
		/*更新缓存*/
		test.setValue("CachePut");
		test = testDao.CachePut(test);
		System.out.println(test.getValue());
		test = testDao.Cacheable(1);
		System.out.println(test.getValue());
		/*清除缓存*/
		test.setValue("CacheEvict");
		test = testDao.CacheEvict(test);
		System.out.println(test.getValue());
		test = testDao.Cacheable(1);
		System.out.println(test.getValue());
		
		/*
			期待结果：
			--------get from db--------
			CacheEvict
			--------CachePut--------
			CachePut
			CachePut
			--------CacheEvict--------
			CacheEvict
			--------get from db--------
			CacheEvict
		*/
	}
	
	@Test
	public void utilTest() throws InterruptedException {
		String cacheName = CacheName.tenSecond.name();
		String key = "key";
		String value = "value";
		/*测试失效时间*/
		EhcacheUtil.put(cacheName, key, value);
		System.out.println("---------put cache--------");
		System.out.println("sleep 9 s");
		Thread.sleep(9000);
		System.out.println(" get cache:" + EhcacheUtil.get(cacheName, key));
		System.out.println("sleep 2 s");
		Thread.sleep(2000);
		System.out.println(" get cache:" + EhcacheUtil.get(cacheName, key));
		
		System.out.println("---------------------------------------------");
		
		/*测试增删查操作*/
		EhcacheUtil.put(cacheName, key, value);
		System.out.println("---------put cache--------");
		System.out.println(" get cache:" + EhcacheUtil.get(cacheName, key));
		EhcacheUtil.remove(cacheName, key);
		System.out.println("---------reomve cache--------");
		System.out.println(" get cache:" + EhcacheUtil.get(cacheName, key));
		
		/*
			期待结果：
			---------put cache--------
			sleep 9 s
			 get cache:value
			sleep 2 s
			 get cache:null
			---------------------------------------------
			---------put cache--------
			 get cache:value
			---------reomve cache--------
			 get cache:null
		 */
	}
	
	@Test
	public void mixTest() {
		String cacheName = CacheName.tenSecond.name();
		String key = "TbTest_tenSecond1";
		TbTest test;
		/*缓存数据*/
		test = testDao.Cacheable(1);
		System.out.println(test.getValue());
		test = EhcacheUtil.get(cacheName, key);
		System.out.println(" get test value :" + test.getValue());
		/*更新缓存*/
		test.setValue("CachePut");
		test = testDao.CachePut(test);
		System.out.println(test.getValue());
		test = EhcacheUtil.get(cacheName, key);
		System.out.println(" get test value :" + test.getValue());
		/*清除缓存*/
		test.setValue("CacheEvict");
		test = testDao.CacheEvict(test);
		System.out.println(test.getValue());
		test = EhcacheUtil.get(cacheName, key);
		System.out.println(" get test :" + test);
		
		System.out.println("---------------------------------------------");
		
		/*测试增删查操作*/
		TbTest cache = new TbTest();
		cache.setId(1);
		EhcacheUtil.put(cacheName, key, cache);
		System.out.println("---------put cache--------");
		cache = testDao.Cacheable(1);
		System.out.println(cache.getValue());
		EhcacheUtil.remove(cacheName, key);
		System.out.println("---------reomve cache--------");
		cache = testDao.Cacheable(1);
		System.out.println(cache.getValue());
		
		/*	
			期待结果：
			--------get from db--------
			CacheEvict
			 get test value :CacheEvict
			--------CachePut--------
			CachePut
			 get test value :CachePut
			--------CacheEvict--------
			CacheEvict
			 get test :null
			---------------------------------------------
			---------put cache--------
			null
			---------reomve cache--------
			--------get from db--------
			CacheEvict
		*/
		
	}

}
