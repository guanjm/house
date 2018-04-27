package gjm.house.designPattern.behavioralPattern.observerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 推模型
 * 抽象目标/抽象被观察者(Observable)
 * 
 * 1、把所有对观察者对象的引用保存在一个聚集（比如ArrayList对象）里，每个目标都可以有任何数量的观察者。
 * 2、提供一个接口，可以增加和删除观察者对象。
 * 3、提供一个接口，通知观察者对象本目标变更
 * 
 * @author guanjm
 *
 */
public abstract class PushSubject {
	
	/**
	 * 保存注册的观察者
	 */
	private List<PushObserver> observers = new ArrayList<PushObserver>();
	
	/**
	 * 注册观察者
	 * @author guanjm
	 * @param observer
	 */
	public void attach(PushObserver observer) {
		observers.add(observer);
	}
	
	/**
	 * 删除观察者
	 * @author guanjm
	 * @param observer
	 */
	public void detach(PushObserver observer) {
		observers.remove(observer);
	}
	
	/**
	 * 通知所有注册的观察者
	 * @author guanjm
	 * @param state 部分变更信息
	 */
	public void nodifyObservers(String state) {
		for(PushObserver observer : observers) {
			observer.update(state);
		}
	}

}
