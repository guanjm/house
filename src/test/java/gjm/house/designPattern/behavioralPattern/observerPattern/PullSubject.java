package gjm.house.designPattern.behavioralPattern.observerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 拉模型
 * 抽象目标
 * @author guanjm
 *
 */
public abstract class PullSubject implements Cloneable {
	
	/**
	 * 保存注册的观察者
	 */
	private List<PullObserver> observers = new ArrayList<PullObserver>();
	
	/**
	 * 注册观察者
	 * @author guanjm
	 * @param observer
	 */
	public void attach(PullObserver observer) {
		observers.add(observer);
	}
	
	/**
	 * 删除观察者
	 * @author guanjm
	 * @param observer
	 */
	public void detach(PullObserver observer) {
		observers.remove(observer);
	}
	
	/**
	 * 通知所有注册的观察者（整个对象传给观察者）
	 * @author guanjm
	 */
	public void notifyObserver() {
		for(PullObserver observer : observers) {
			observer.update(this);
		}
	}
	
	public PullSubject clone() {
		PullSubject subject = null;
		try {
			subject = (PullSubject) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return subject;
	}

}
