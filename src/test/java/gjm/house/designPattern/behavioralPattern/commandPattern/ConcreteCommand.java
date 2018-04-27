package gjm.house.designPattern.behavioralPattern.commandPattern;

/**
 * 具体命令角色
 * 
 * 定义一个接收者和行为之间的弱耦合；实现execute()方法，负责调用接收者的相应操作。execute()方法通常叫做执行方法
 * 
 * @author guanjm
 *
 */
public class ConcreteCommand implements Command {
	
	/**
	 * 持有相应的接受者对象
	 */
	private Receiver receiver;
	
	/**
	 * 
	 * @param receiver
	 */
	public ConcreteCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		//调用接受者执行方法
		receiver.function();
	}

}
