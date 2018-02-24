package gjm.house.demo.dao.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gjm.house.common.dao.impl.GenericDaoImpl;
import gjm.house.demo.dao.ITestDao;
import gjm.house.demo.entity.TbTest;

@Repository
public class TestDaoImpl extends GenericDaoImpl<TbTest> implements ITestDao {

	@Transactional
	@Cacheable(value = "tenSecond", key = "#id")
	public TbTest Cacheable(Integer id) {
		System.out.println("--------get from db--------");
		return this.get(id);
	}
	
	@Transactional
	@CachePut(value = "tenSecond", key = "#test.id")
	public TbTest CachePut(TbTest test) {
		System.out.println("--------CachePut--------");
		this.update(test);
		return test;
	}
	
	@Transactional
	@CacheEvict(value = "tenSecond", key = "#test.id")
	public TbTest CacheEvict(TbTest test) {
		System.out.println("--------CacheEvict--------");
		this.update(test);
		return test;
	}

}

