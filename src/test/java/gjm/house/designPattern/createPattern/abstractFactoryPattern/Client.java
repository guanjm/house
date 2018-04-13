package gjm.house.designPattern.createPattern.abstractFactoryPattern;

/**
 * 抽象工厂模式
 * 按需实现不同的工厂实现类
 * （可扩展，通过实现不同的工厂实现类）
 * 
 * 不同的工厂实现类生产各自不同的产品组合（产品族）（具体的IProduct + 具体的IInstruction + 或更多）
 * 不同的工厂实现类能生产多类产品（IProduct + IInstruction + 或更多）
 * 
 * @author guanjm
 *
 */
public class Client {
	
	public static void main(String[] args) {
		
		//指定工厂实现类A
		IFactory factoryA = new FactoryA();
		//工厂A生产的产品指引A
		IInstruction instructionA = factoryA.provide();
		//工厂A生产的产品A
		IProduct productA = factoryA.produce();
		//产品指引A介绍产品
		instructionA.instruct();
		//产品A工作
		productA.function();
		
		//指定工厂实现类B
		IFactory factoryB = new FactoryB();
		//工厂B生产的产品指引B
		IInstruction instructionB = factoryB.provide();
		//工厂B生产的产品B
		IProduct productB = factoryB.produce();
		//产品指引B介绍产品
		instructionB.instruct();
		//产品B工作
		productB.function();
	}

}
