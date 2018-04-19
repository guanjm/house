package gjm.house.designPattern.structuralPattern.compositePattern;

/**
 * 组合模式(合成模式)
 * 
 * 1、透明组合模式（Component类中声明人任何成员组件访问和管理方法，需要实现类重写，客户端可以调用）
 * 2、安全组合模式（Component类中不声明人任何成员组件访问和管理方法，由Composite自己提供，客户端无法调用）
 * 
 * @author guanjm
 *
 */
public class Client {
	
	public static void main(String[] args) {
		
		//叶子构件
		Component leafA = new Leaf("leafA");
		Component leafB = new Leaf("leafB");
		Component leafC = new Leaf("leafC");
		
		//容器构件
		Component compositeA = new Composite("compositeA");
		Component compositeB = new Composite("compositeB");
		Component compositeC = new Composite("compositeC");
		
		compositeA.add(leafA);
		compositeA.add(compositeB);
		compositeB.add(leafB);
		compositeB.add(leafC);
		compositeB.add(compositeC);
		compositeA.operation();
	}

}
