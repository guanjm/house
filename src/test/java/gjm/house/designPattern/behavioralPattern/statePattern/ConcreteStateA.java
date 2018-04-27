package gjm.house.designPattern.behavioralPattern.statePattern;

/**
 * 具体状态
 * 
 * 每一个具体状态类都实现了环境（Context）的一个状态所对应的行为。
 * 
 * @author guanjm
 *
 */
public class ConcreteStateA implements State {

	@Override
	public void handle(Context context) {
		switch(context.getStateType()) {
			case A : 
				System.out.println(" ConcreteStateA handle "); 
				break;
			case B : 
				System.out.println(" dispense ConcreteStateB ");
				context.setState(new ConcreteStateB());
				context.request();
		}
	}

}
