package gjm.house.designPattern.structuralPattern.bridgePattern;

/**
 * 桥接模式
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
		//具体实现类A
		Implementor concreteImplementtorA = new ConcreteImplementorA();
		//具体实现类B
		Implementor concreteImplementtorB = new ConcreteImplementorB();
		
		//桥接类A（具有额外A功能）
		Abstraction refinedAbstractionA = new RefinedAbstractionA();
		//桥接类B（具有额外B功能）
		Abstraction refinedAbstractionB = new RefinedAbstractionB();
		
		//具体实现类A + 额外A功能
		refinedAbstractionA.setImplementor(concreteImplementtorA);
		refinedAbstractionA.extendedFunction();
		
		//具体实现类A + 额外B功能
		refinedAbstractionB.setImplementor(concreteImplementtorA);
		refinedAbstractionB.extendedFunction();
		
		//具体实现类B + 额外A功能
		refinedAbstractionA.setImplementor(concreteImplementtorB);
		refinedAbstractionA.extendedFunction();
		
		//具体实现类B + 额外B功能
		refinedAbstractionB.setImplementor(concreteImplementtorB);
		refinedAbstractionB.extendedFunction();
		
	}

}
