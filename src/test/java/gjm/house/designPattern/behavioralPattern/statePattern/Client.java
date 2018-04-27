package gjm.house.designPattern.behavioralPattern.statePattern;

import gjm.house.designPattern.behavioralPattern.statePattern.Context.StateType;

/**
 * 状态模式/状态对象模式（Pattern of Objects for States）
 * 
 * 与策略模式区别：该模式不用知道具体对象，状态的迁移是由Context或者State对象自己来管理的
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
		
		//创建环境并传入内部状态
		Context contextA = new Context(StateType.A);
		//执行方法
		contextA.request();
		System.out.println("-----------split line------------");
		//设置内部状态
		Context contextB = new Context(StateType.B);
		//执行方法
		contextB.request();
	}

}
