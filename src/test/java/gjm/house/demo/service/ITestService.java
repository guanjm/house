package gjm.house.demo.service;

import gjm.house.demo.entity.TbTest;

public interface ITestService {
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	TbTest get(Integer id);
	
	/**
	 * 保存实体
	 * @param test
	 * @return
	 */
	TbTest save(TbTest test);

}
