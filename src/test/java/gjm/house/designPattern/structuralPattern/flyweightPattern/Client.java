package gjm.house.designPattern.structuralPattern.flyweightPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 享元模式
 * 
 * 采用一个共享来避免大量拥有相同内容对象的开销
 * 内蕴状态(Internal State)和外蕴状态(External State)
 * 内蕴状态是存储在享元对象内部的，并且是不会随环境的改变而有所不同。因此，一个享元可以具有内蕴状态并可以共享。
 * 外蕴状态是随环境的改变而改变的、不可以共享的，必须由客户端保存，并在享元对象被创建之后，在需要使用的时候再传入到享元对象内部。外蕴状态不可以影响享元对象的内蕴状态，它们是相互独立的。
 * 享元模式可以分成单纯享元模式和复合享元模式两种形式
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
		
		//单纯享元模式
		Flyweight flyweightA = FlyweightFactory.factory("a");
		//工作
		flyweightA.function("A");
		//再次获取享元实例对象
		FlyweightFactory.factory("a");
		
		//复合享元模式
		List<String> internalStateList = new ArrayList<String>();
		internalStateList.add("a");
		internalStateList.add("b");
		internalStateList.add("c");
		
		Flyweight flyweightB = FlyweightFactory.factory(internalStateList);
		
		flyweightB.function(" 23333! ");
	}

}
