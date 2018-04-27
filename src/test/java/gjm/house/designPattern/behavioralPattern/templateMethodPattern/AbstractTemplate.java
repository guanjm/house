package gjm.house.designPattern.behavioralPattern.templateMethodPattern;

/**
 * 抽象模板
 * 模板方法所代表的行为称为顶级行为，其逻辑称为顶级逻辑
 * 
 * 1、定义了一个或多个抽象操作，以便让子类实现。这些抽象操作叫做基本方法/基本操作(primitive operation)，它们是一个顶级逻辑的组成步骤。
 * 2、定义并实现了一个模板方法。这个模板方法一般是一个具体方法，它给出了一个顶级逻辑的骨架，而逻辑的组成步骤在相应的抽象操作中，推迟到子类实现。顶级逻辑也有可能调用一些具体方法。
 * 
 * @author guanjm
 *
 */
public abstract class AbstractTemplate {
	
	/**
	 * 模板方法1（由基本方法组成）
	 * @author guanjm
	 */
	public void templateMethod1() {
		abstractMethod();
		concreteMethod();
	}
	
	/**
	 * 模板方法2（由基本方法组成）
	 * @author guanjm
	 */
	public void templateMethod2() {
		abstractMethod();
		concreteMethod();
		hookMethod();
	}
	
	/**
	 * 抽象方法（基本方法）
	 * @author guanjm
	 */
	abstract void abstractMethod();
	
	/**
	 * 具体方法（基本方法）
	 * @author guanjm
	 */
	void concreteMethod() {
		System.out.println(" this is concreteMethod! ");
	}
	
	/**
	 * 钩子方法（基本方法）
	 * @author guanjm
	 */
	void hookMethod() {}

}
