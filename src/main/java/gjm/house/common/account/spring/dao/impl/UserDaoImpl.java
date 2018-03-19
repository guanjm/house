package gjm.house.common.account.spring.dao.impl;

import org.springframework.stereotype.Repository;

import gjm.house.common.account.spring.dao.IUserDao;
import gjm.house.common.account.spring.entity.TbUser;
import gjm.house.common.dao.impl.GenericDaoImpl;

@Repository
public class UserDaoImpl extends GenericDaoImpl<TbUser> implements IUserDao {

}
