package gjm.house.demo.dao;

import gjm.house.common.dao.IGenericDao;
import gjm.house.demo.entity.TbTest;

public interface ITestDao extends IGenericDao<TbTest> {
	
	/**
	 * 缓存数据
	 * @param test
	 * @return
	 */
	TbTest Cacheable(Integer id);
	
	/**
	 * 更新缓存
	 * @param test
	 * @return
	 */
	TbTest CachePut(TbTest test);
	
	/**
	 * 清除缓存
	 * @param test
	 * @return
	 */
	TbTest CacheEvict(TbTest test);
	
}
