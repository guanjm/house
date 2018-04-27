package gjm.house.designPattern.behavioralPattern.chainofResponsibilityPattern;

/**
 * 抽象处理者角色
 * 
 * 定义出一个处理请求的接口
 * 可以定义出一个方法以设定和返回对下家的引用
 * 
 * @author guanjm
 *
 */
public abstract class Handler {
	
	/**
	 * 持有后继的责任对象
	 */
	private Handler successor;
	
	/**
     * 示意处理请求的方法，虽然这个示意方法是没有传入参数的
     * 但实际是可以传入参数的，根据具体需要来选择是否传递参数
     */
	public abstract void handleRequest();
	
	/**
	 * 设置后续的责任对象
	 * @author guanjm
	 * @param successor
	 */
	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}
	
	/**
	 * 获取后续的责任对象
	 * @author guanjm
	 * @return
	 */
	public Handler getSuccessor() {
		return successor;
	}
	

}
