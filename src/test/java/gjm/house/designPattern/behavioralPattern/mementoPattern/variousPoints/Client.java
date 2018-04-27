package gjm.house.designPattern.behavioralPattern.mementoPattern.variousPoints;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录（多重检查点）
 * @author guanjm
 *
 */
public class Client {
	
	public static void main(String[] args) {
		//初始内部状态
		String state = "test1";
		List<String> states = new ArrayList<String>();
		states.add("one");
		//改变内部状态并存档
		Originator originator = new Originator();
		originator.setStates(state, states);
		originator.printState();
		Memento memento = originator.createMemento();
		Caretaker caretaker = new Caretaker();
		caretaker.saveMemento(memento);
		//改变内部状态并存档
		state = "test2";
		states.add("two");
		originator.setStates(state, states);
		originator.printState();
		memento = originator.createMemento();
		caretaker.saveMemento(memento);
		//改变内部状态并存档
		state = "test3";
		states.add("three");
		originator.setStates(state, states);
		originator.printState();
		memento = originator.createMemento();
		caretaker.saveMemento(memento);
		//读取存档
		memento = caretaker.retrieveMemento(0);
		originator.restoreMemento(memento);
		originator.printState();
		//读取存档
		memento = caretaker.retrieveMemento(1);
		originator.restoreMemento(memento);
		originator.printState();
	}
	
}
