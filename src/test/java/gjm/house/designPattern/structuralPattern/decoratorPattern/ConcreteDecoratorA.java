package gjm.house.designPattern.structuralPattern.decoratorPattern;

/**
 * 具体装饰
 * 透明（装饰模式）
 * 
 * 负责给构件对象添加上附加的责任
 * 
 * @author guanjm
 *
 */
public class ConcreteDecoratorA extends Decorator {

	public ConcreteDecoratorA(Component component) {
		super(component);
	}
	
	@Override
	public void function(){
		System.out.println(" this is ConcreteDecoratorA! ");
	}

}
