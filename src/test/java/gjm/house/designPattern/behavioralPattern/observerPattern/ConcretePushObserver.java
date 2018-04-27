package gjm.house.designPattern.behavioralPattern.observerPattern;

/**
 * 推模型
 * 具体观察者
 * 
 * 1、如需要可以维护一个指向ConcreteSubject对象的引用
 * 2、存储有关状态,这些状态应与目标的状态保持一致
 * 
 * @author guanjm
 *
 */
public class ConcretePushObserver implements PushObserver {
	
	/**
	 * 保存目标部分内部信息
	 */
	private String state;

	@Override
	public void update(String newState) {
		System.out.println(" this is ConcretePushObserver ");
		System.out.println(" got change message : " + state + " ==> " + newState);
		state = newState;
	}

}
