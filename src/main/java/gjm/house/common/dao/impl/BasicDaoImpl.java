package gjm.house.common.dao.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import gjm.house.common.dao.IBasicDao;

public class BasicDaoImpl extends HibernateDaoSupport implements IBasicDao {
	
	@Autowired
	private void setMySessionFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public <T> T save(T entity) {
		this.getHibernateTemplate().save(entity);
		return entity;
	}

	public <T> void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
	}

	public <T> void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}
	
	public <T> T get(Class<T> entityClass, Serializable id) {
		return (T) this.getHibernateTemplate().get(entityClass, id);
	}
	
}
