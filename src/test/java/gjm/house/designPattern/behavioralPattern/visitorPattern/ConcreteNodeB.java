package gjm.house.designPattern.behavioralPattern.visitorPattern;

/**
 * 具体节点
 * 
 * 实现了抽象节点所规定的接受操作。
 * 
 * @author guanjm
 *
 */
public class ConcreteNodeB implements Node {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public void function() {
		System.out.println(" this is ConcreteNodeB ");
	}

}
