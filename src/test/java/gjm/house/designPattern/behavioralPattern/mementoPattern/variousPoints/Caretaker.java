package gjm.house.designPattern.behavioralPattern.mementoPattern.variousPoints;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责人
 * 
 * @author guanjm
 *
 */
public class Caretaker {
	
	/**
	 * 保存多个存档
	 */
	private List<Memento> mementos = new ArrayList<Memento>();
	
	/**
	 * 取回备忘录（读取存档）
	 * @author guanjm
	 * @param index	存档版本
	 * @return
	 */
	public Memento retrieveMemento(int index) {
		return mementos.get(index);
	}
	
	/**
	 * 保存备忘录（保存存档）
	 * @author guanjm
	 * @param memento
	 */
	public void saveMemento(Memento memento) {
		this.mementos.add(memento);
	}

}
