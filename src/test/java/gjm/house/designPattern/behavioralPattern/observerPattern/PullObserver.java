package gjm.house.designPattern.behavioralPattern.observerPattern;

/**
 * 拉模型
 * 抽象观察者
 * @author guanjm
 *
 */
public interface PullObserver {

	/**
	 * 更新接口
	 * @author guanjm
	 * @param newSubject 整个目标对象
	 */
	public void update(PullSubject newSubject);
	
}
