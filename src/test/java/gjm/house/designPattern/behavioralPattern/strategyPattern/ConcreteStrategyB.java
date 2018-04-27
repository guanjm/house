package gjm.house.designPattern.behavioralPattern.strategyPattern;

/**
 * 具体策略
 * 
 * 1、实现具体的策略接口
 * 
 * @author guanjm
 *
 */
public class ConcreteStrategyB implements Strategy {

	@Override
	public void strategyInterface() {
		System.out.println(" this is ConcreteStrategyB! ");
	}

}