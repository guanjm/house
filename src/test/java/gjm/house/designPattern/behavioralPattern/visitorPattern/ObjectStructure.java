package gjm.house.designPattern.behavioralPattern.visitorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 结构对象
 * 
 * 责任：
 * 1、可以遍历结构中的所有元素
 * 2、如果需要，提供一个高层次的接口让访问者对象可以访问每一个元素
 * 2、如果需要，可以设计成一个复合对象或者一个聚集，如List或Set
 * 
 * @author guanjm
 *
 */
public class ObjectStructure {
	
	private List<Node> nodes = new ArrayList<Node>();
	
	/**
	 * 执行方法
	 * @author guanjm
	 * @param visitor	访问者
	 */
	public void action(Visitor visitor) {
		for(Node node : nodes) {
			node.accept(visitor);
		}
	}
	
	/**
	 * 添加节点
	 * @author guanjm
	 * @param node
	 */
	public void add(Node node) {
		nodes.add(node);
	}

}
