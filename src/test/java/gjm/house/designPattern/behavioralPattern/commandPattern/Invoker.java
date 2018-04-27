package gjm.house.designPattern.behavioralPattern.commandPattern;

/**
 * 请求者角色
 * 
 * 负责调用命令对象执行请求，相关的方法叫做行动方法
 * 
 * @author guanjm
 *
 */
public class Invoker {
	
	private Command command;
	
	public Invoker(Command command) {
		this.command = command;
	}
	
	/**
	 * 行动方法
	 * @author guanjm
	 */
	public void function() {
		command.execute();
	}

}
