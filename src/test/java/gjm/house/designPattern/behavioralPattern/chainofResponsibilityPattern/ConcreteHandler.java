package gjm.house.designPattern.behavioralPattern.chainofResponsibilityPattern;

/**
 * 具体处理者角色
 * 
 * @author guanjm
 *
 */
public class ConcreteHandler extends Handler{

	@Override
	public void handleRequest() {
		if(getSuccessor() == null) {
			System.out.println(" handle the request! ");
		} else {
			System.out.println(" pass to the successor! ");
			getSuccessor().handleRequest();
		}
	}

}
