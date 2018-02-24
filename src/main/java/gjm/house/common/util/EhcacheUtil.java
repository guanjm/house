package gjm.house.common.util;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * ehcache工具类
 * @author Tim
 *
 */
public class EhcacheUtil {
	
	public enum CacheName{
		tenSecond;	//10秒缓存
	}
	
	private static CacheManager cacheManager = CacheManager.getInstance();
	
	/**
	 * 添加缓存
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	public static void put(String cacheName, Serializable key, Serializable value) {
		Cache cache = cacheManager.getCache(cacheName);
		if(cache != null) {
			Element element = new Element(key, value);
			cache.put(element);
		}
	}
	
	/**
	 * 获取缓存
	 * @param cacheName
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T get(String cacheName, Serializable key) {
		Cache cache = cacheManager.getCache(cacheName);
		if(cache != null) {
			Element element = cache.get(key);
			if(element != null && element.getObjectValue() != null) {
				return (T) element.getObjectValue();
			}
		}
		return null;
	}
	
	/**
	 * 删除缓存
	 * @param cacheName
	 * @param key
	 */
	public static void remove(String cacheName, Serializable key) {
		Cache cache = cacheManager.getCache(cacheName);
		if(cache != null) {
			cache.remove(key);
		}
	}

}
