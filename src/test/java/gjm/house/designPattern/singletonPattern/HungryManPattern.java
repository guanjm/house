package gjm.house.designPattern.singletonPattern;

/**
 * 单例模式——饿汉模式
 * 1、私有静态类实例引用
 * 2、私有无参构造方法
 * 3、公有静态返回类实例方法
 * 
 * 无lazy loading
 * 类加载慢
 * 无线程问题
 * 不推荐
 * 
 * @author guanjm
 *
 */
@Deprecated
public class HungryManPattern {
	
	//1、私有静态类实例引用
	private static HungryManPattern instance = new HungryManPattern();
	
	//2、私有无参构造方法
	private HungryManPattern () {}
	
	//3、公有静态返回类实例方法
	public static HungryManPattern getInstance() {
		return instance;
	}

}
