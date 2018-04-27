package gjm.house.designPattern.behavioralPattern.mementoPattern.black;

/**
 * 发起人（游戏）
 * 
 * @author guanjm
 *
 */
public class Originator {
	
	/**
	 * 持有内部状态（当前进度）
	 */
	private String state;
	
	/**
	 * 创建当前内部状态的备忘录（保存存档）
	 * @author guanjm
	 * @return
	 */
	public Memento createMemento() {
		return new Memento(state);
	}
	
	public void restoreMemento(IMemento memento) {
		this.state = ((Memento)memento).getState();
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
	
	/**
	 * 备忘录（进度存档）
	 * @author guanjm
	 *
	 */
	private class Memento implements IMemento {
		/**
		 * 记录内部状态（记录存档）
		 */
		private String state;
		
		public Memento(String state) {
			this.state = state;
		}

		public String getState() {
			return state;
		}
	}

}
