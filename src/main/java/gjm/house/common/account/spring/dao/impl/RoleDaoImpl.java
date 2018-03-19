package gjm.house.common.account.spring.dao.impl;

import org.springframework.stereotype.Repository;

import gjm.house.common.account.spring.dao.IRoleDao;
import gjm.house.common.account.spring.entity.TbRole;
import gjm.house.common.dao.impl.GenericDaoImpl;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<TbRole> implements IRoleDao {

}
