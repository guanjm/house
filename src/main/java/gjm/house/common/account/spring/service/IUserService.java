package gjm.house.common.account.spring.service;

import gjm.house.common.account.spring.entity.TbUser;

public interface IUserService {
	
	/**
	 * 认证账号和密码
	 * @author guanjm
	 * @param userName
	 * @param password
	 * @return
	 */
	TbUser authenticate(String userName, String password);

}
