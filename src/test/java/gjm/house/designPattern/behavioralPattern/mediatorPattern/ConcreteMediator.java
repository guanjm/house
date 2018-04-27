package gjm.house.designPattern.behavioralPattern.mediatorPattern;

/**
 * 具体中介者
 * 
 * 通过协调各个同事对象来实现协作行为，它维持了对各个同事对象的引用
 * 
 * @author guanjm
 *
 */
public class ConcreteMediator implements Mediator {
	
	/**
	 * 持有对各个同事对象的引用
	 */
	private Colleague concreteColleagueA;
	private Colleague concreteColleagueB;
	
	/**
	 * 构造方法
	 * @param concreteColleagueA	具体同事对象
	 * @param concreteColleagueB	具体同事对象
	 */
	public ConcreteMediator(Colleague concreteColleagueA, Colleague concreteColleagueB) {
		this.concreteColleagueA = concreteColleagueA;
		this.concreteColleagueB = concreteColleagueB;
	}

	@Override
	public void operationA() {
		concreteColleagueA.function();
	}

	@Override
	public void operationB() {
		concreteColleagueB.function();
	}

}
