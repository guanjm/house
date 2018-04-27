package gjm.house.designPattern.behavioralPattern.mediatorPattern;

/**
 * 抽象同事类
 * 
 * 定义各个同事类公有的方法，并声明了一些抽象方法来供子类实现，
 * 同时它维持了一个对抽象中介者类的引用，其子类可以通过该引用来与中介者通信
 * 
 * @author guanjm
 *
 */
public interface Colleague {
	
	/**
	 * 功能
	 * @author guanjm
	 */
	public void function();
	
	/**
	 * 额外功能（对其他同事类的操作）
	 * @author guanjm
	 * @param concreteMediator 具体中介者
	 */
	public void extraFunction(Mediator concreteMediator);
	
}
