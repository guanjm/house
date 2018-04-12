package gjm.house.designPattern.singletonPattern;

/**
 * 单例模式——双重校验锁
 * 1、私有静态类实例引用
 * 2、私有无参构造方法
 * 3、公有静态返回类实例方法
 * 
 * lazy loading
 * 效率较高
 * 无线程问题
 * 推荐使用
 * 
 * @author guanjm
 *
 */
public class DoubleCheckPattern {
	
	//1、私有静态类实例引用
	private volatile static DoubleCheckPattern instance;
	
	//2、私有无参构造方法
	private DoubleCheckPattern() {}
	
	//3、公有静态返回类实例方法
	public static DoubleCheckPattern getInstance() {
		if(instance == null) {
			synchronized(DoubleCheckPattern.class) {
				if(instance == null) {
					return new DoubleCheckPattern();
				}
			}
		}
		return instance;
	}

}
