package gjm.house.common.dao;

import java.io.Serializable;

/**
 * 基础Dao
 * @author Tim
 *
 */
public interface IBasicDao {
	
	/**
	 * 保存实体
	 * @param entity
	 * @return 
	 */
	<T> T save(T entity);
	
	/**
	 * 删除实体
	 * @param entity
	 */
	<T> void delete(T entity);
	
	/**
	 * 更新实体
	 * @param entity
	 */
	<T> void update(T entity);
	
	/**
	 * 获取实体
	 * @param entityClass
	 * @param id
	 * @return
	 */
	<T> T get(Class<T> entityClass, Serializable id);

}
