package gjm.house.demo.listener;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

/**
 * hibernateSessionFactory监听器
 * 只能用内置的session，不能用注入的dao
 * @author guanjm
 *
 */
@SuppressWarnings("serial")
@Component
public class TestListener implements PostInsertEventListener, PostUpdateEventListener, PostDeleteEventListener {
	
	@Resource
	private SessionFactory sessionFactory;
	
	//注册监听
	@PostConstruct
	public void registerListeners() {
        EventListenerRegistry registry  = ((SessionFactoryImpl)sessionFactory).
        		getServiceRegistry().getService(EventListenerRegistry.class); 
        registry.getEventListenerGroup(EventType.POST_INSERT).appendListener(this);
        registry.getEventListenerGroup(EventType.POST_UPDATE).appendListener(this);
        registry.getEventListenerGroup(EventType.POST_DELETE).appendListener(this);
    }
	
	/**
	 * 删除后操作
	 */
	public void onPostDelete(PostDeleteEvent event) {
		//TODO 
		System.out.println("--------删除成功！--------");
	}
	
	/**
	 * 更新后操作
	 */
	public void onPostUpdate(PostUpdateEvent event) {
		//TODO 
		System.out.println("--------更新成功！--------");
	}
	
	/**
	 * 插入后操作
	 */
	public void onPostInsert(PostInsertEvent event) {
		//TODO 
		System.out.println("--------插入成功！--------");
	}

	public boolean requiresPostCommitHanding(EntityPersister persister) {
		return false;
	}

}
