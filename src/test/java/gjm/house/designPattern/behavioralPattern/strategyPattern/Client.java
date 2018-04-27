package gjm.house.designPattern.behavioralPattern.strategyPattern;

/**
 * 策略模式
 * 
 * 与状态模式区别：该模式客户端需要知道用到哪个具体对象
 * 
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
		
		//创建环境
		Context context = new Context();
		//设置具体策略
		context.setStrategy(new ConcreteStrategyA());
		//执行策略
		context.contextInterface();
		System.out.println("---------------split line---------------");
		//设置具体策略
		context.setStrategy(new ConcreteStrategyB());
		//执行策略
		context.contextInterface();
	}

}
