package gjm.house.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gjm.house.demo.dao.ITestDao;
import gjm.house.demo.entity.TbTest;
import gjm.house.demo.service.ITestService;

@Service
@Transactional
public class TestServiceImpl implements ITestService {

	@Resource
	private ITestDao testDao;
	
	public TbTest get(Integer id) {
		return testDao.get(id);
	}

	public TbTest save(TbTest test) {
		return testDao.save(test);
	}

}
