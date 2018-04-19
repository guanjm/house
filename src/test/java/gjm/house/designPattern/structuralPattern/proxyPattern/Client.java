package gjm.house.designPattern.structuralPattern.proxyPattern;

/**
 * 代理模式
 * 
 * 与装饰模式对比，代理模式更注重方法的改写，类方法的修改
 * 
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
		//实例化目标对象
		RealObject realObject = new RealObject();
		//目标对象工作
		realObject.function();
		
		//代理管理目标对象
		AbstractObject proxyObject = new ProxyObject(realObject);
		//代理对象工作
		proxyObject.function();
	}

}
