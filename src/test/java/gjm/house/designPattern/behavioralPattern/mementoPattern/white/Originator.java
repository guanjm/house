package gjm.house.designPattern.behavioralPattern.mementoPattern.white;

/**
 * 发起人
 * 
 * 责任：
 * 1、创建一个含有当前的内部状态的备忘录对象。
 * 2、使用备忘录对象存储其内部状态。
 * 
 * @author guanjm
 *
 */
//游戏
public class Originator {
	
	/**
	 * 持有内部状态（当前游戏进度）
	 */
	private String state;
	
	/**
	 * 创建当前内部状态的备忘录对象（创建存档）
	 * @author guanjm
	 * @return
	 */
	public Memento createMemento() {
		return new Memento(state);
	}
	
	/**
	 * 恢复当前内部状态为备忘录中状态（读取存档）
	 * @author guanjm
	 * @param memento 备忘录对象
	 */
	public void restoreMemento(Memento memento) {
		this.state = memento.getState();
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}

}
