package gjm.house.common.account.spring.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import gjm.house.common.account.spring.dao.IPermissionDao;
import gjm.house.common.account.spring.service.IPermissionService;

@Service
public class PermissionServiceImpl implements IPermissionService {
	
	@Resource
	private IPermissionDao permissionDao;

	@Override
	public List<Object> getPermissionId(Integer userId) {
		String sql = " select distinct(p.id) from t_permission p, t_role_permission rp, t_user_role ur, t_role r"
				+ " where p.flag = 0 and r.flag = 0 and p.id = rp.permission_id and rp.role_id = ur.role_id "
				+ " and ur.role_id = r.id and ur.user_id = ? ";
		return permissionDao.findBySql(sql, new Object[] {userId});
	}

}
