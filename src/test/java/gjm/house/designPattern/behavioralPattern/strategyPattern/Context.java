package gjm.house.designPattern.behavioralPattern.strategyPattern;

/**
 * 环境
 * 
 * 1、维护一个对Strategy对象的引用。
 * 2、用一个ConcreteStrategy对象来配置。
 * 3、可定义一个接口来让Stategy访问它的数据。
 * 
 * @author guanjm
 *
 */
public class Context {
	
	/**
	 * 持有具体策略实例引用
	 */
	private Strategy strategy;
	
	/**
	 * 设置具体策略
	 * @author guanjm
	 * @param strategy
	 */
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	/**
	 * 策略方法
	 * @author guanjm
	 */
	public void contextInterface() {
		strategy.strategyInterface();
	}

}
