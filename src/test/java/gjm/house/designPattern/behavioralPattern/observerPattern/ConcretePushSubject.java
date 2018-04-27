package gjm.house.designPattern.behavioralPattern.observerPattern;

/**
 * 推模型
 * 具体目标
 * 
 * 1、将有关状态存入具体观察者对象。
 * 2、在具体目标的内部状态改变时，给所有登记过的观察者发出通知。
 * 
 * @author guanjm
 *
 */
public class ConcretePushSubject extends PushSubject {
	
	/**
	 * 内部状态
	 */
	private String state1;
	
	private String state2;
	
	/**
	 * 内部状态变更（通知已注册的观察者）
	 * @author guanjm
	 * @param newState
	 */
	public void change(String newState) {
		System.out.println(" ConcretePushSubject is changing: ");
		System.out.println(" " + state1 + " ==> " + newState);
		state1 = newState;
		super.nodifyObservers(state1);
	}

}
