package gjm.house.designPattern.behavioralPattern.commandPattern;

/**
 * 命令模式（行动模式/交易模式）
 * 
 * @author guanjm
 *
 */
public class Client {
	
	/**
	 * 客户端
	 * 
	 * 创建一个具体命令(ConcreteCommand)对象并确定其接收者
	 * 
	 * @author guanjm
	 * @param args
	 */
	public static void main(String[] args) {
		
		//实例化接受者对象
		Receiver receiver = new Receiver();
		//实例化具体命令对象
		Command concreteCommand = new ConcreteCommand(receiver);
		//实例化请求者对象
		Invoker invoker = new Invoker(concreteCommand);
		//请求者发出请求
		invoker.function();
	}

}
