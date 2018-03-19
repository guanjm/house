package gjm.house.common.account.spring.dao.impl;

import org.springframework.stereotype.Repository;

import gjm.house.common.account.spring.dao.IPermissionDao;
import gjm.house.common.account.spring.entity.TbPermission;
import gjm.house.common.dao.impl.GenericDaoImpl;

@Repository
public class PermissionDaoImpl extends GenericDaoImpl<TbPermission> implements IPermissionDao {

}
