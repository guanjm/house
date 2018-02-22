package gjm.house.common.dao;

import java.util.List;
import java.util.Map;

/**
 * 泛型Dao
 * @author Tim
 *
 * @param <T>
 */
public interface IGenericDao<T> extends IBasicDao {
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	T get(Integer id);
	
	/**
	 * hql查询获取实体List
	 * @param hql
	 * @param values
	 * @return
	 */
	List<T> find(String hql, Object[] values);
	
	/**
	 * sql查询获取实体List
	 * @param sql
	 * @param values
	 * @return
	 */
	List<T> findBySQL(String sql, Object[] values);
	
	/**
	 * sql查询获取对象List
	 * @param sql
	 * @param values
	 * @return
	 */
	List<Object> findBySql(String sql, Object[] values);
	
	/**
	 * sql查询获取Map
	 * @param sql
	 * @param values
	 * @return
	 */
	List<Map<String, Object>> findToMap(String sql, Object[] values);
	
}
