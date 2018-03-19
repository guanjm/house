package gjm.house.common.account.spring.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import gjm.house.common.account.spring.dao.IUserDao;
import gjm.house.common.account.spring.entity.TbUser;
import gjm.house.common.account.spring.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Resource
	private IUserDao userDao;

	public TbUser authenticate(String userName, String password) {
		String hql = " from TbUser where userName = ? and password = ? ";
		return userDao.find(hql, new Object[] {userName, password}).get(0);
	}

}
