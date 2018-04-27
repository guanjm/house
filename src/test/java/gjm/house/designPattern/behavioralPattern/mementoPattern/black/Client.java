package gjm.house.designPattern.behavioralPattern.mementoPattern.black;

/**
 * 备忘录模式（黑箱）
 * 添加备注后成为（自述历史模式History-On-Self Pattern）
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
		
		Originator originator = new Originator();
		originator.setState(" now is good state! ");
		System.out.println(originator.getState());
		IMemento memento = originator.createMemento();
//		Caretaker caretaker = new Caretaker();
//		caretaker.saveMemento(memento);
		
		originator.setState(" now is bad state! ");
		System.out.println(originator.getState());
		
//		memento = caretaker.retrieveMemento();
		originator.restoreMemento(memento);
		System.out.println(originator.getState());
	}

}
