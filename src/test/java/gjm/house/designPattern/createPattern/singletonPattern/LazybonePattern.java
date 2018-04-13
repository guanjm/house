package gjm.house.designPattern.createPattern.singletonPattern;

/**
 * 单例模式——懒汉模式
 * 1、私有静态类实例引用
 * 2、私有无参构造方法
 * 3、公有静态返回类实例方法
 * 
 * lazy loading
 * 锁导致效率低
 * 无线程问题
 * 不推荐
 * 
 * @author guanjm
 *
 */
@Deprecated
public class LazybonePattern {
	
	//1、私有静态类实例引用
	private static LazybonePattern instance;
	
	//2、私有无参构造方法
	private LazybonePattern() {}
	
	//3、公有静态返回类实例方法
	public static synchronized LazybonePattern getInstance() {
		if(instance == null) {
			return new LazybonePattern();
		}
		return instance;
	}
	
}
