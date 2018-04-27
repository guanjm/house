package gjm.house.designPattern.behavioralPattern.observerPattern;

/**
 * 拉模型
 * 具体观察者
 * @author guanjm
 *
 */
public class ConcretePullObserver implements PullObserver {
	
	/**
	 * 持有目标对象的引用
	 */
	private PullSubject subject;

	@Override
	public void update(PullSubject newSubject) {
		System.out.println(" this is ConcretePullObserver ");
		System.out.println(" got change message : " + subject + " ==> " + newSubject);
		this.subject = newSubject.clone();
	}

}
