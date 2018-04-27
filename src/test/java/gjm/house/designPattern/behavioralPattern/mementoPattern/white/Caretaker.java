package gjm.house.designPattern.behavioralPattern.mementoPattern.white;

/**
 * 负责人
 * 
 * 责任：
 * 1、负责保存备忘录对象。
 * 2、不检查备忘录对象的内容。
 * 
 * @author guanjm
 *
 */
//进度管理器
public class Caretaker {
	
	/**
	 * 保存存档
	 */
	private Memento memento;
	
	/**
	 * 取回备忘录（读取存档）
	 * @author guanjm
	 * @return
	 */
	public Memento retrieveMemento() {
		return memento;
	}
	
	/**
	 * 保存备忘录（保存存档）
	 * @author guanjm
	 * @param memento
	 */
	public void saveMemento(Memento memento) {
		this.memento = memento;
	}

}
