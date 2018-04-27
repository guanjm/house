package gjm.house.designPattern.behavioralPattern.mementoPattern.variousPoints;

import java.util.List;

/**
 * 备忘录
 * @author guanjm
 *
 */
public class Memento {
	
	/**
	 * 记录内部状态
	 */
	private String state;
	
	private List<String> states;
	
	/**
	 * 构造方法
	 * @param state
	 * @param states
	 */
	public Memento(String state, List<String> states) {
		this.state = state;
		this.states = states;
	}
	
	public String getState() {
		return state;
	}

	public List<String> getStates() {
		return states;
	}
	
}
