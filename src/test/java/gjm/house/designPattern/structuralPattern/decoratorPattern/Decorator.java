package gjm.house.designPattern.structuralPattern.decoratorPattern;

/**
 * 装饰
 * 
 * 持有一个构件（Component）对象的实例，并实现一个与抽象构件接口一致的接口
 * 
 * @author guanjm
 *
 */
public class Decorator implements Component {
	
	/**
	 * 持有一个构件（Component）对象的实例
	 */
	private Component component;
	
	public Decorator(Component component) {
		this.component = component;
	}

	@Override
	public void function() {
		//委派给构件
		component.function();
	}

}
