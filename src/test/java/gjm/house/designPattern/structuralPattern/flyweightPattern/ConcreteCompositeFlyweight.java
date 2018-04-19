package gjm.house.designPattern.structuralPattern.flyweightPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 复合享元
 * 
 * 复合享元角色所代表的对象是不可以共享的，但是一个复合享元对象可以分解成为多个本身是单纯享元对象的组合。
 * 复合享元角色又称作不可共享的享元对象。
 * 
 * @author guanjm
 *
 */
public class ConcreteCompositeFlyweight implements Flyweight {
	
	//保存已实例对象
	private Map<String, Flyweight> map = new HashMap<String, Flyweight>();
	
	/**
	 * 存入缓存
	 * @author guanjm
	 * @param internal
	 * @param flyweight
	 */
	public void put(String internal, Flyweight flyweight) {
		map.put(internal, flyweight);
	}

	@Override
	public void function(String externalState) {
		for(Flyweight flyweight : map.values()) {
			flyweight.function(externalState);
		}
	}
	
}
