package gjm.house.common.shiro.simpleFilterFactoryBean.securityManager;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gjm.house.common.util.RedisUtil;
import gjm.house.common.util.SerializeUtil;
import redis.clients.jedis.Jedis;

public class SimpleCacheManager implements CacheManager {
	
	private static final Logger logger = LoggerFactory.getLogger(SimpleCacheManager.class);
	
	private RedisUtil redisUtil;

	private String keyPrefix;
	
	public void setRedisUtil(RedisUtil redisUtil) {
		this.redisUtil = redisUtil;
	}
	
	public void setKeyPrefix(String keyPrefix) {
		this.keyPrefix = keyPrefix;
	}

	@Override
	public <K, V> Cache<K, V> getCache(String cacheName) throws CacheException {
		return new currentCache<K, V>(cacheName);
	}
	
	class currentCache<K, V> implements Cache<K, V>{
		

		private String cacheName;
		
		public void setCacheName(String cacheName) {
			this.cacheName = cacheName;
		}

		public currentCache(String cacheName) {
			this.cacheName = cacheName;
		}
		
		@Override
		public void clear() throws CacheException {
			
		}

		@Override
		@SuppressWarnings("unchecked")
		public V get(K key) throws CacheException {
			return (V) redisUtil.get(keyPrefix + cacheName + key, Object.class);
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public Set<K> keys() {
			return (Set<K>) redisUtil.getLikeKeyList(keyPrefix + cacheName);
		}
		
		@Override
		@SuppressWarnings("unchecked")
		public V put(K key, V value) throws CacheException {
			V preValue = null;
			Jedis jedis = null;
			try {
				jedis = redisUtil.getJedis();
				preValue = (V) SerializeUtil.deserialize(
						jedis.getSet(SerializeUtil.serialize(keyPrefix + cacheName + key), SerializeUtil.serialize(value))
						, Object.class);
			} catch (Exception e) {
				logger.error(" SimpleCacheManager put error:{} ", e);
			} finally {
				redisUtil.returnJedis(jedis);
			}
			return preValue;
		}

		@Override
		@SuppressWarnings("unchecked")
		public V remove(K key) throws CacheException {
			V preValue = null;
			Jedis jedis = null;
			try {
				jedis = redisUtil.getJedis();
				preValue = (V) SerializeUtil.deserialize(jedis.get(SerializeUtil.serialize(keyPrefix + cacheName + key)), Object.class);
				jedis.del(SerializeUtil.serialize(key));
			} catch (Exception e) {
				logger.error(" SimpleCacheManager remove error:{} ", e);
			} finally {
				redisUtil.returnJedis(jedis);
			}
			return preValue;
		}

		@Override
		public int size() {
			return redisUtil.getLikeKeyList(keyPrefix + cacheName).size();
		}

		@Override
		@SuppressWarnings("unchecked")
		public Collection<V> values() {
			Set<V> result = new HashSet<V>();
			Jedis jedis = null;
			try {
				jedis = redisUtil.getJedis();
				Set<String> likeKeyList = redisUtil.getLikeKeyList(keyPrefix + cacheName);
				if(!likeKeyList.isEmpty()) {
					for(String key : likeKeyList) {
						result.add((V) jedis.get(SerializeUtil.serialize(key)));
					}
				}
			} catch (Exception e) {
				logger.error(" SimpleCacheManager remove error:{} ", e);
			} finally {
				redisUtil.returnJedis(jedis);
			}
			return result;
		}
		
	}

	
}
