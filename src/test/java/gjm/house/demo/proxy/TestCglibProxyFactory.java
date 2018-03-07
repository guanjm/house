package gjm.house.demo.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import gjm.house.demo.dao.impl.TestDaoImpl;
import gjm.house.demo.entity.TbTest;

/**
 * Cglib代理（子类代理）
 * 目标对象不需要实现接口，不能为final
 * @author Tim
 *
 */
public class TestCglibProxyFactory implements MethodInterceptor {
	
	/**
	 * 目标对象
	 */
	private Object target;
	
	/**
	 * 处理过程
	 * Object：目标对象
	 * Method：目标方法
	 * Object[]：目标方法参数
	 * MethodProxy：方法代理对象本身
	 * 
	 */
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		//TODO 目标方法执行前处理
		System.out.println("--------目标方法执行前处理-------");
		
		//原方法执行
		Object result = arg3.invoke(target, arg2);
		
		//TODO 目标方法执行后处理
		System.out.println("--------目标方法执行后处理-------");
		
		return result;
	}
	
	/**
	 * 生成代理对象
	 * @param target
	 * @return
	 */
	public Object getProxyInstance(Object target) {
		this.target = target;
		//字节码增强器
		Enhancer enhancer = new Enhancer();
		//设置父类
		enhancer.setSuperclass(target.getClass());
		//设置类装载器
		enhancer.setClassLoader(target.getClass().getClassLoader());
		//设置回调代理类（即Cglib代理类）
		enhancer.setCallback(this);
		//创建代理对象（子类代理对象）
		return enhancer.create();
	}
	
	/**
	 * 使用实例
	 * @param args
	 */
	public static void main(String[] args) {
		//目标对象
		TestCglibObject target = new TestCglibObject();
		//创建代理对象
		TestCglibObject proxy = (TestCglibObject) new TestCglibProxyFactory().getProxyInstance(target);
		//执行方法
		proxy.run();
	}
	
}
