package gjm.house.common.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate4.HibernateCallback;

import gjm.house.common.dao.IGenericDao;

public class GenericDaoImpl<T> extends BasicDaoImpl implements IGenericDao<T> {
	
	protected Class<T> entityClass;
	
	protected String className;
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		this.entityClass = null;
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] typeArray = ((ParameterizedType) type).getActualTypeArguments();
			this.entityClass = (Class<T>) typeArray[0];
			this.className = typeArray[0].getTypeName();
		}
	}

	public T get(Integer id) {
		return this.get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object[] values) {
		return (List<T>) this.getHibernateTemplate().find(hql, values);
	}

	@SuppressWarnings("unchecked")
	public List<T> findBySQL(String sql, Object[] values) {
		return (List<T>) this.getHibernateTemplate().execute(
				new HibernateCallback<Object>() {
					public Object doInHibernate(Session session) throws HibernateException {
						SQLQuery query = session.createSQLQuery(sql);
						query.addEntity(entityClass);
						if (values != null) {
							for (int i = 0; i < values.length; i++) {
								query.setParameter(i, values[i]);
							}
						}
						return query.list();
					}
				}
		);
	}

	@SuppressWarnings("unchecked")
	public List<Object> findBySql(String sql, Object[] values) {
		return (List<Object>) this.getHibernateTemplate().execute(
				new HibernateCallback<Object>() {
					public Object doInHibernate(Session session)throws HibernateException {
						SQLQuery query = session.createSQLQuery(sql);
						if (values != null) {
							for (int i = 0; i < values.length; i++) {
								query.setParameter(i, values[i]);
							}
						}
						return query.list();
					}
				}
		);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findToMap(String sql, Object[] values) {
		return (List<Map<String, Object>>) this.getHibernateTemplate().execute(
				new HibernateCallback<Object>() {
					public Object doInHibernate(Session session) throws HibernateException {
						SQLQuery query = session.createSQLQuery(sql);
						query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
						if (values != null) {
							for (int i = 0; i < values.length; i++) {
								query.setParameter(i, values[i]);
							}
						}
						return query.list();
					}
				}
		);
	}

}
