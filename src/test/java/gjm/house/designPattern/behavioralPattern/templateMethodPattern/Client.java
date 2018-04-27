package gjm.house.designPattern.behavioralPattern.templateMethodPattern;

/**
 * 模板方法模式
 * 子类可以置换掉父类的可变部分，但是子类却不可以改变模板方法所代表的顶级逻辑。
 * 
 * 模板方法：
 * 1、定义在抽象类中的，把基本操作方法组合在一起形成一个总算法或一个总行为的方法。
 * 2、可以有任意多个模板方法，而不限于一个。每一个模板方法都可以调用任意多个具体方法。
 * 基本方法：
 * 抽象方法(Abstract Method)：一个抽象方法由抽象类声明，由具体子类实现。
 * 具体方法(Concrete Method)：一个具体方法由抽象类声明并实现，而子类并不实现或置换。
 * 钩子方法(Hook Method)：一个钩子方法由抽象类声明并实现，而子类会加以扩展。通常抽象类给出的实现是一个空实现，作为方法的默认实现。
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
		
		//创建具体模板
		AbstractTemplate templateA = new ConcreteTemplateA();
		//执行模板方法
		templateA.templateMethod1();
		//执行模板方法
		templateA.templateMethod2();
		System.out.println("-------------split line--------------");
		
		//创建具体模板
		AbstractTemplate templateB = new ConcreteTemplateB();
		//执行模板方法
		templateB.templateMethod1();
		//执行模板方法
		templateB.templateMethod2();
	}

}
