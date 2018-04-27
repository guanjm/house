package gjm.house.designPattern.behavioralPattern.commandPattern;

/**
 * 接收者角色
 * 
 * 负责具体实施和执行一个请求。
 * 任何一个类都可以成为接收者，实施和执行请求的方法叫做行动方法
 * 
 * @author guanjm
 *
 */
public class Receiver {
	
	/**
	 * 真正执行命令的操作
	 * @author guanjm
	 */
	public void function() {
		System.out.println(" receiver function! ");
	}

}
