package gjm.house.designPattern.behavioralPattern.observerPattern;

/**
 * 推模型
 * 抽象观察者
 * 
 * 1、为所有的具体观察者定义一个接口，在得到目标的通知时更新自己，这个接口叫做更新接口。
 * 
 * @author guanjm
 *
 */
public interface PushObserver {
	
	/**
	 * 更新接口
	 * @author guanjm
	 * @param newState	目标部分变更信息
	 */
	public void update(String newState);

}
