package gjm.house.common.account.spring.service;

import java.util.List;

public interface IRoleService {

	/**
	 * 根据用户id获取角色id
	 * @author guanjm
	 * @param userId
	 * @return
	 */
	List<Object> getRoleId(Integer userId);

}
