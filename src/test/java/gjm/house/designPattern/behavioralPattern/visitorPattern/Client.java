package gjm.house.designPattern.behavioralPattern.visitorPattern;

/**
 * 访问者模式
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
		
		//创建结构对象
		ObjectStructure structure = new ObjectStructure();
		//往结构对象添加节点A
		structure.add(new ConcreteNodeA());
		//往结构对象添加节点B
		structure.add(new ConcreteNodeB());
		//用观察者A遍历结构节点
		structure.action(new ConcreteVisitorA());
		//用观察者B遍历结构节点
		structure.action(new ConcreteVisitorB());
	}

}
