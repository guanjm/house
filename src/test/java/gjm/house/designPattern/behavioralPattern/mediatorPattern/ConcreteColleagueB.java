package gjm.house.designPattern.behavioralPattern.mediatorPattern;

/**
 * 具体同事类
 * 
 * 每一个同事对象在需要和其他同事对象通信时，先与中介者通信，通过中介者来间接完成与其他同事类的通信
 * 
 * @author guanjm
 *
 */
public class ConcreteColleagueB implements Colleague {
	
	@Override
	public void function() {
		System.out.println(" this is ConcreteColleagueB! ");
	}

	@Override
	public void extraFunction(Mediator concreteMediator) {
		concreteMediator.operationA();
	}

}
