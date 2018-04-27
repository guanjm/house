package gjm.house.designPattern.behavioralPattern.mediatorPattern;

/**
 * 中介者模式（调停者模式）
 * @author guanjm
 *
 */
public class Client {
	
	/**
	 * 客户端
	 * @author guanjm
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * 具体同事实例对象
		 */
		Colleague concreteColleagueA = new ConcreteColleagueA();
		Colleague concreteColleagueB = new ConcreteColleagueB();
		/**
		 * 具体中介者实例对象
		 */
		Mediator concreteMediator = new ConcreteMediator(concreteColleagueA, concreteColleagueB);
		/**
		 * 通过中介者对其他同事类进行调用
		 */
		concreteColleagueA.extraFunction(concreteMediator);
		concreteColleagueB.extraFunction(concreteMediator);
	}

}
