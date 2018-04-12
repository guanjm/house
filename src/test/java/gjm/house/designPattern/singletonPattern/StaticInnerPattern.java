package gjm.house.designPattern.singletonPattern;

/**
 * 单例模式——静态内部类
 * 1、私有静态类实例引用
 * 2、私有无参构造方法
 * 3、公有静态返回类实例方法
 * 
 * lazy loading
 * 效率高
 * 无线程问题
 * 推荐
 * 
 * @author guanjm
 *
 */
public class StaticInnerPattern {
	
	//内部类不会显示加载
	private static class SingletonHolder{
		//1、私有静态类实例引用
		private static StaticInnerPattern instance = new StaticInnerPattern();
	}
	
	//2、私有无参构造方法
	private StaticInnerPattern() {}
	
	//3、公有静态返回类实例方法
	public static StaticInnerPattern getInstance() {
		return SingletonHolder.instance;
	}
	
}
