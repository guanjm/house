package gjm.house.designPattern.structuralPattern.flyweightPattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 享元工厂
 * 
 * 负责创建和管理享元角色，必须保证享元对象可以被系统适当地共享。
 * 当一个客户端对象调用一个享元对象的时候，享元工厂角色会检查系统中是否已经有一个符合要求的享元对象。
 * 如果已经有了，享元工厂角色就应当提供这个已有的享元对象；
 * 如果系统中没有一个适当的享元对象的话，享元工厂角色就应当创建一个合适的享元对象。
 * 
 * @author guanjm
 *
 */
public class FlyweightFactory {
	
	//保存已实例对象
	private static Map<String, Flyweight> map = new HashMap<String, Flyweight>();
	
	/**
	 * 复合享元工厂方法
	 * @author guanjm
	 * @param internalStateList
	 * @return
	 */
	public static Flyweight factory(List<String> internalStateList) {
		ConcreteCompositeFlyweight concreteCompositeFlyweight = new ConcreteCompositeFlyweight();
		for(String internalState : internalStateList) {
			//调用了单纯享元角色的工厂方法
			concreteCompositeFlyweight.put(internalState, factory(internalState));
		}
		return concreteCompositeFlyweight;
	}
	
	/**
	 * 单纯享元工厂方法
	 * @author guanjm
	 * @param internalState
	 * @return
	 */
	public static Flyweight factory(String internalState) {
		//从缓存中获取内蕴状态
		Flyweight flyweight = map.get(internalState);
		if(flyweight == null) {
			System.out.println(" new instance ");
			//新建一个实例对象
			flyweight = new ConcreteFlyweight(internalState);
			//存入缓存
			map.put(internalState, flyweight);
		}
		return flyweight;
	}

}
