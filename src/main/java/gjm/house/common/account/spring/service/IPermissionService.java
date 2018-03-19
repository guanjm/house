package gjm.house.common.account.spring.service;

import java.util.List;

public interface IPermissionService {

	/**
	 * 根据用户id获取权限id
	 * @author guanjm
	 * @param userId
	 * @return
	 */
	List<Object> getPermissionId(Integer userId);

}
