package gjm.house.designPattern.structuralPattern.compositePattern;

import java.util.LinkedList;
import java.util.List;

/**
 * 容器构件
 * 
 * 需要递归调用其子构件功能
 * 
 * @author guanjm
 *
 */
public class Composite implements Component {
	
	private List<Component> list = new LinkedList<Component>();
	
	private String name;
	
	public Composite(String name) {
		this.name = name;
	}

	@Override
	public void add(Component component) {
		list.add(component);
	}

	@Override
	public void remove(Component component) {
		list.remove(component);
	}

	@Override
	public Component getChild(int i) {
		return list.get(0);
	}

	/**
	 * 功能
	 * 需要递归调用其子构件功能
	 */
	@Override
	public void operation() {
		System.out.println(" this is " + name);
		for(Component component:list) {
			component.operation();
		}
	}

}
