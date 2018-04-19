package gjm.house.designPattern.structuralPattern.decoratorPattern;

/**
 * 具体装饰
 * （半透明装饰模式）
 * 
 * 负责给构件对象添加上附加的责任
 * 
 * @author guanjm
 *
 */
public class ConcreteDecoratorB extends Decorator {
	
	public ConcreteDecoratorB(Component component) {
		super(component);
	}
	
	@Override
	public void function(){
		System.out.println(" this is ConcreteDecoratorB! ");
	}
	
	public void extraFunction() {
		System.out.println(" this is extraFunctionB! ");
	}

}
