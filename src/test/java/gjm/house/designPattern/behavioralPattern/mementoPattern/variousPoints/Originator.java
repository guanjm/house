package gjm.house.designPattern.behavioralPattern.mementoPattern.variousPoints;

import java.util.ArrayList;
import java.util.List;

/**
 * 发起人
 * 
 * @author guanjm
 *
 */
public class Originator {
	
	/**
	 * 内部状态
	 */
	private String state;
	
	private List<String> states;
	
	/**
	 * 创建当前内部状态的备忘录
	 * 
	 * 深拷贝以防备忘录状态被修改
	 * 
	 * @author guanjm
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Memento createMemento() {
		return new Memento(state, (List<String>) ((ArrayList<String>)states).clone());
	}
	
	/**
	 * 恢复当前内部状态为备忘录中的状态
	 * 
	 * 深拷贝以防备忘录状态被修改
	 * 
	 * @author guanjm
	 * @param memento
	 */
	@SuppressWarnings("unchecked")
	public void restoreMemento(Memento memento) {
		this.state = memento.getState();
		this.states = (List<String>) ((ArrayList<String>)memento.getStates()).clone();
	}
	
	/**
	 * 输出所有内部状态
	 * @author guanjm
	 */
	public void printState() {
		System.out.println("-------------split line-------------");
		System.out.println(state);
		for(String str : states) {
			System.out.println(str);
		}
	}
	
	public String getState() {
		return state;
	}

	public List<String> getStates() {
		return states;
	}

	public void setStates(String state, List<String> states) {
		this.state = state;
		this.states = states;
	}
}
