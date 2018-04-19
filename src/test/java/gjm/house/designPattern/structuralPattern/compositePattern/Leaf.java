package gjm.house.designPattern.structuralPattern.compositePattern;

/**
 * 叶子构件
 * @author guanjm
 *
 */
public class Leaf implements Component {
	
	private String name;
	
	public Leaf(String name) {
		this.name = name;
	}

	@Override
	public void add(Component component) {
		System.out.println(" this is leaf without child! ");
	}

	@Override
	public void remove(Component component) {
		System.out.println(" this is leaf without child! ");
	}

	@Override
	public Component getChild(int i) {
		System.out.println(" this is leaf without child! ");
		return null;
	}

	@Override
	public void operation() {
		System.out.println(" this is "+ name);
	}

}
