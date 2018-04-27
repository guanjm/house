package gjm.house.designPattern.behavioralPattern.statePattern;

/**
 * 环境
 * 
 * 1、定义客户端所感兴趣的接口
 * 2、维护一个具体状态类的实例，这个具体状态类的实例给出此环境对象的现有状态。
 * 
 * @author guanjm
 *
 */
public class Context {
	
	enum StateType{
		A,
		B;
	}
	
	/**
	 * 持有具体状态实例
	 */
	private State state = new ConcreteStateA();
	
	/**
	 * 持有内部状态
	 */
	private StateType stateType;
	
	/**
	 * 构造方法
	 * @param stateType 内部状态
	 */
	public Context(StateType stateType) {
		this.stateType = stateType;
	}
	
	/**
	 * 设置具体状态类
	 * @author guanjm
	 * @param state
	 */
	public void setState(State state) {
		this.state = state;
	}
	
	/**
	 * 获取当前内部状态
	 * @author guanjm
	 * @return
	 */
	public StateType getStateType() {
		return stateType;
	}

	/**
	 * 用户感兴趣的接口
	 * @author guanjm
	 */
	public void request() {
		setState(state);
		state.handle(this);
	}
}
