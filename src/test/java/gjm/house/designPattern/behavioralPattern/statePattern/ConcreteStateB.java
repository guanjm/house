package gjm.house.designPattern.behavioralPattern.statePattern;

import gjm.house.designPattern.behavioralPattern.statePattern.Context.StateType;

/**
 * 具体状态
 * 
 * 每一个具体状态类都实现了环境（Context）的一个状态所对应的行为。
 * 
 * @author guanjm
 *
 */
public class ConcreteStateB implements State {
	
	@Override
	public void handle(Context context) {
		if(context.getStateType().equals(StateType.B)) {
			System.out.println(" ConcreteStateB handle ");
		}
	}

}
