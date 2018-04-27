package gjm.house.designPattern.behavioralPattern.observerPattern;

/**
 * 拉模型
 * 具体目标
 * @author guanjm
 *
 */
public class ConcretePullSubject extends PullSubject {
	
	/**
	 * 内部状态
	 */
	private String state1;
	
	private String state2;
	
	/**
	 * 内部状态变更（通知已注册的观察者）
	 * @author guanjm
	 * @param state1
	 * @param state2
	 */
	public void change(String state1, String state2) {
		this.state1 = state1;
		this.state2 = state2;
		System.out.println(" ConcretePullSubject is changing: ");
		super.notifyObserver();
	}

}
