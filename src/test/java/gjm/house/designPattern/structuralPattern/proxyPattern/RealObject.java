package gjm.house.designPattern.structuralPattern.proxyPattern;

/**
 * 目标对象角色
 * 
 * 定义了代理对象所代表的目标对象
 * 
 * @author guanjm
 *
 */
public class RealObject extends AbstractObject {

	@Override
	public void function() {
		System.out.println(" this is RealObject! ");
	}

}
