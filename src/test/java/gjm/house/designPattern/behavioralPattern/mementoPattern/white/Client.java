package gjm.house.designPattern.behavioralPattern.mementoPattern.white;

/**
 * 备忘录模式/快照模式(Snapshot Pattern)/Token模式
 * @author guanjm
 *
 */
public class Client {
	
	/**
	 * 客户端
	 * @author guanjm
	 * @param args
	 */
	public static void main(String[] args) {

		//开始游戏（SL大法）
		Originator originator = new Originator();
		//副本前状态
		originator.setState(" now is good state! ");
		System.out.println(originator.getState());
		//存档
		Memento memento = originator.createMemento();
//		Caretaker caretaker = new Caretaker();
//		caretaker.saveMemento(memento);
		
		//打boss失败后状态
		originator.setState(" now is bad state! ");
		System.out.println(originator.getState());
		
		//读取副本前存档
//		memento = caretaker.retrieveMemento();
		originator.restoreMemento(memento);
		System.out.println(originator.getState());
	}

}
