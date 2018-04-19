package gjm.house.designPattern.structuralPattern.decoratorPattern;

/**
 * 装饰模式（包装模式）
 * 
 * 透明性：装饰角色的接口与抽象构件角色的接口是否完全一致
 * 半透明的装饰模式实际上就是处于适配器模式与装饰模式之间的灰色地带
 * 
 * 装饰模式：增强功能/不改变接口
 * 半装饰模式：增强功能/改变接口
 * 适配模式：不改变功能/改变接口
 * 
 * 与代理模式相比，装饰模式更注重类方法的增强，类方法的增加
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
		
		//具体构件
		Component concreteComponent = new ConcreteComponent();
		//构件工作
		concreteComponent.function();
		
		//透明修饰模式
		Component concreteDecoratorA = new ConcreteDecoratorA(concreteComponent);
		//构件工作
		concreteDecoratorA.function();
		
		//半透明修饰模式
		ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB(concreteComponent);
		//构件工作
		concreteDecoratorB.function();
		//构件增强功能工作
		concreteDecoratorB.extraFunction();
	}

}
