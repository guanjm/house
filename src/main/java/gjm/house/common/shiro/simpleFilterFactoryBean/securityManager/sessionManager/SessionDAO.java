package gjm.house.common.shiro.simpleFilterFactoryBean.securityManager.sessionManager;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gjm.house.common.util.RedisUtil;
import gjm.house.common.util.SerializeUtil;
import redis.clients.jedis.Jedis;

/**
 * session管理器
 * @author guanjm
 *
 */
public class SessionDAO extends AbstractSessionDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(SessionDAO.class);
	
	/**
	 * sessionId前缀
	 */
	private String sessionIdPrefix; 
	
	private RedisUtil redisUtil;
	
	public void setRedisUtil(RedisUtil redisUtil) {
		this.redisUtil = redisUtil;
	}

	public void setSessionIdPrefix(String sessionIdPrefix) {
		this.sessionIdPrefix = sessionIdPrefix;
	}

	@Override
	public void delete(Session session) {
		deleteSession(session.getId());
	}

	@Override
	public Collection<Session> getActiveSessions() {
		return getAllSessions();
	}

	@Override
	public void update(Session session) throws UnknownSessionException {
		updateSession(session);
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		saveSession(session);
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		return getSession(sessionId);
	}
	
	/**
	 * 保存session
	 * @author guanjm
	 * @param session
	 */
	private void saveSession(Session session) {
		if(redisUtil.exists(sessionIdPrefix + session.getId())) {
			return;
		}
		redisUtil.set(sessionIdPrefix + session.getId(), session, (int) session.getTimeout()/1000);
	}
	
	/**
	 * 获取session
	 * @author guanjm
	 * @param sessionId
	 */
	private Session getSession(Serializable sessionId) {
		return (Session) redisUtil.get(sessionIdPrefix + sessionId, Object.class);
	}
	
	/**
	 * 更新session
	 * @author guanjm
	 * @param session
	 */
	private void updateSession(Session session) {
		redisUtil.set(sessionIdPrefix + session.getId(), session, (int) session.getTimeout()/1000);
	}
	
	/**
	 * 删除session
	 * @author guanjm
	 * @param sessionId
	 */
	private void deleteSession(Serializable sessionId) {
		redisUtil.del(sessionIdPrefix + sessionId);
	}
	
	/**
	 * 获取所有session
	 * @author guanjm
	 * @return
	 */
	private Collection<Session> getAllSessions() {
		Jedis jedis = null;
		try {
			jedis = redisUtil.getJedis();
			Set<String> keys = jedis.keys(sessionIdPrefix + "*");
			if(keys != null && keys.size() > 0) {
				Set<Session> result = new HashSet<Session>();
				for(String key : keys) {
					result.add(SerializeUtil.deserialize(jedis.get(SerializeUtil.serialize(key)), Session.class));
				}
				if(result.size() > 0) {
					return result;
				}
			}
		} catch (Exception e) {
			logger.error(" SessionDAO getAllSessions error:{} ", e);
		} finally {
			redisUtil.returnJedis(jedis);
		}
		return Collections.emptySet();
	}
	
}
