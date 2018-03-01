package gjm.house.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import gjm.house.demo.dao.ITestDao;
import gjm.house.demo.dao.impl.TestDaoImpl;

/**
 * JDK代理
 * 目标对象需要实现接口
 * 动态代理不需要实现接口,但是需要指定接口类型
 * @author Tim
 *
 */
public class TestJDKProxyFactory {
	
	/**
	 * 生成代理对象
	 * @param target 目标对象
	 * @return
	 */
	public Object getProxyInstance(Object target) {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(),
				new InvocationHandler() {
					/**
					 * 处理过程
					 * 在invoke方法编码指定返回的代理对象干的工作
					 * proxy：代理对象本身
					 * method：目标方法
					 * args：目标方法参数
					 */
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//TODO 目标方法执行前处理
						System.out.println("--------目标方法执行前处理-------");
						
						//原方法执行
						Object result = method.invoke(target, args);
						
						//TODO 目标方法执行后处理
						System.out.println("--------目标方法执行后处理-------");
						
						return result;
					}
				});
	}
	
	/**
	 * 使用实例
	 * @param args
	 */
	public static void main(String[] args) {
		//目标对象
		ITestDao testDao = new TestDaoImpl();
		//创建代理对象
		ITestDao proxy = (ITestDao) new TestJDKProxyFactory().getProxyInstance(testDao);
		//执行方法
		proxy.save(null);
	}

}
