package gjm.house.designPattern.behavioralPattern.visitorPattern;

/**
 * 抽象访问者
 * 
 * 声明了一个或者多个方法操作，形成所有的具体访问者角色必须实现的接口。
 * 
 * @author guanjm
 *
 */
public interface Visitor {
	
	/**
	 * 对具体的节点A访问
	 * @author guanjm
	 * @param node
	 */
	public void visit(ConcreteNodeA node);
	
	/**
	 * 对具体的节点B访问
	 * @author guanjm
	 * @param node
	 */
	public void visit(ConcreteNodeB node);
}
