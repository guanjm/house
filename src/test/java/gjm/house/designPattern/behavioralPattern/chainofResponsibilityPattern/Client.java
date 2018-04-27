package gjm.house.designPattern.behavioralPattern.chainofResponsibilityPattern;

/**
 * 责任链模式
 * 
 * 纯的责任链模式：
 * 	1、要求一个具体的处理者对象只能在两个行为中选择一个：一是承担责任，而是把责任推给下家。不允许出现某一个具体处理者对象在承担了一部分责任后又 把责任向下传的情况。
 * 	2、一个请求必须被某一个处理者对象所接收，不允许一个请求可以最终不被任何接收端对象所接收。
 * 
 * 典例：tomcat的filter
 * 
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
		
		//实例化具体处理者A
		Handler concreteHandlerA = new ConcreteHandler();
		//实例化具体处理者B
		Handler concreteHandlerB = new ConcreteHandler();
		//设置续的责任对象
		concreteHandlerA.setSuccessor(concreteHandlerB);
		//处理请求
		concreteHandlerA.handleRequest();
	}

}
