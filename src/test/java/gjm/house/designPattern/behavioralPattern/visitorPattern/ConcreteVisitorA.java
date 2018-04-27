package gjm.house.designPattern.behavioralPattern.visitorPattern;

/**
 * 具体访问者
 * 
 * 实现抽象访问者所声明的接口，也就是抽象访问者所声明的各个访问操作。
 * 
 * @author guanjm
 *
 */
public class ConcreteVisitorA implements Visitor {

	@Override
	public void visit(ConcreteNodeA node) {
		System.out.print(" this is ConcreteVisitorA + ");
		node.function();
	}

	@Override
	public void visit(ConcreteNodeB node) {
		System.out.print(" this is ConcreteVisitorA + ");
		node.function();
	}

}
