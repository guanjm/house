package gjm.house.designPattern.behavioralPattern.mementoPattern.black;

/**
 * 
 * @author guanjm
 *
 */
public class Caretaker {
	
	/**
	 * 记录备忘录
	 */
	private IMemento memento;

	/**
	 * 取回备忘录
	 * @author guanjm
	 * @return
	 */
	public IMemento retrieveMemento() {
		return memento;
	}

	/**
	 * 保存备忘录
	 * @author guanjm
	 * @param memento
	 */
	public void saveMemento(IMemento memento) {
		this.memento = memento;
	}
	
}
