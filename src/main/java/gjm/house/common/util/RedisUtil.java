package gjm.house.common.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import javassist.bytecode.ByteArray;
import redis.clients.jedis.BinaryJedis;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis工具类
 * @author Tim
 *
 */
@Component
public class RedisUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(RedisUtil.class);
	
	@Resource
	private JedisPool jedisPool;
	
	/**
	 * 获取Jedis实例
	 * @return
	 */
	private synchronized Jedis getJedis() {
		try {
			return jedisPool.getResource();
		} catch (Exception e) {
			logger.error(" RedisUtil getJedis error : ", e);
		}
		return null;
	}
	
	/**
	 * 归还Jedis实例
	 * @param jedis
	 */
	@SuppressWarnings("deprecation")
	private void returnJedis(Jedis jedis) {
		try {
			jedisPool.returnResource(jedis);
		} catch (Exception e) {
			logger.error(" RedisUtil returnJedis error : ", e);
		}
	}
	
	/**
	 * 执行lua语句（未完成）
	 * @param script
	 * @param keys
	 * @param args
	 * @return
	 */
	@Deprecated
	public Object eval(String script, int keyCount, Object...params) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.eval(BytesUtil.turnByteArray(script), keyCount, BytesUtil.turn2DByteArray(params));
		} catch (Exception e) {
			logger.error(" RedisUtil eval error:{} script:{} keyCount:{} params:{} ", e, script, keyCount, params);
		} finally {
			returnJedis(jedis);
		}
		return null;
	}
	
	/**
	 * 设置缓存
	 * @param key
	 * @param value
	 */
	public void set(Object key, Object value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.set(BytesUtil.turnByteArray(key), BytesUtil.turnByteArray(value));
		} catch (Exception e) {
			logger.error(" RedisUtil set error:{} key:{} value:{}", e, key, value);
		} finally {
			returnJedis(jedis);
		}
	}
	
	/**
	 * 设置缓存
	 * @param key
	 * @param value
	 * @param expireSeconds
	 */
	public void set(Object key, Object value, int expireSeconds) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			byte[] byteKey = BytesUtil.turnByteArray(key);
			jedis.set(byteKey, BytesUtil.turnByteArray(value));
			jedis.expire(byteKey, expireSeconds);
		} catch (Exception e) {
			logger.error(" RedisUtil set error:{} key:{} value:{} expireSeconds:{}", e, key, value, expireSeconds);
		} finally {
			returnJedis(jedis);
		}
	}
	
	/**
	 * 获取缓存
	 * @param key
	 * @param clazz value数据类型
	 * @return
	 */
	public <K,V> V get(K key, Class<V> clazz) {
		Jedis jedis = null;
		V result = null;
		try {
			jedis = getJedis();
			result = BytesUtil.turnObject(jedis.get(BytesUtil.turnByteArray(key)), clazz);
		} catch (Exception e) {
			logger.error(" RedisUtil get error:{} key:{} clazz:{}", e, key, clazz);
		} finally {
			returnJedis(jedis);
		}
		return result;
	}
	
	/**
	 * 删除缓存
	 * @param key
	 * @return
	 */
	public boolean del(Object key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.del(BytesUtil.turnByteArray(key)) == 1? true : false;
		} catch (Exception e) {
			logger.error(" RedisUtil del error:{} key:{}", e, key);
		} finally {
			returnJedis(jedis);
		}
		return false;
	}
	
	/**
	 * 校验缓存是否存在
	 * @param key
	 * @return
	 */
	public boolean exists(Object key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.exists(BytesUtil.turnByteArray(key));
		} catch (Exception e) {
			logger.error(" RedisUtil exists error:{} key:{}", e, key);
		} finally {
			returnJedis(jedis);
		}
		return false;
	}
	
	/**
	 * 设置过期时间
	 * @param key
	 * @param seconds
	 * @return
	 */
	public boolean expire(Object key, int seconds) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.expire(BytesUtil.turnByteArray(key), seconds) == 1? true : false;
		} catch (Exception e) {
			logger.error(" RedisUtil expire error:{} key:{} seconds:{}", e, key, seconds);
		} finally {
			returnJedis(jedis);
		}
		return false;
	}
	
	/**
	 * 模糊查询key
	 * @param likeKey
	 * @return
	 */
	public Set<String> getLikeKeyList(String likeKey) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.keys("*" + likeKey + "*");
		} catch (Exception e) {
			logger.error(" RedisUtil getLikeKeyList error:{} likeKey:{}", e, likeKey);
		} finally {
			returnJedis(jedis);
		}
		return Collections.emptySet();
	}
	
}
