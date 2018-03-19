package gjm.house.common.account.spring.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import gjm.house.common.account.spring.dao.IRoleDao;
import gjm.house.common.account.spring.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	
	@Resource
	private IRoleDao roleDao;

	public List<Object> getRoleId(Integer userId) {
		String sql = " select r.id from t_role r, t_user_role ur where r.flag = 0 and r.id = ur.role_id and ur.user_id = ? ";
		return roleDao.findBySql(sql, new Object[] {userId});
	}

}
