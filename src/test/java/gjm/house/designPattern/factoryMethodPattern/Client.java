package gjm.house.designPattern.factoryMethodPattern;

/**
 * 工厂方法模式
 * 按需实现不同的工厂实现类
 * （可扩展，通过实现不同的工厂实现类）
 * 
 * 不同的工厂实现类只能生产各自不同的一种产品
 * 不同的工厂实现类只能生产一类产品（IProduct）
 * 
 * @author guanjm
 *
 */
public class Client {
	
	public static void main(String[] args) {
		
		//指定工厂实现类A
		IFactory factoryA = new FactoryA();
		//工厂A生产的产品A
		IProduct productA = factoryA.produce();
		//产品A工作
		productA.function();
		
		//指定工厂实现类B
		IFactory factoryB = new FactoryB();
		//工厂B生产的产品B
		IProduct productB = factoryB.produce();
		//产品B工作
		productB.function();
	}

}
