package gjm.house.designPattern.behavioralPattern.templateMethodPattern;

/**
 * 具体模板
 * 
 * 1、实现父类所定义的一个或多个抽象方法，它们是一个顶级逻辑的组成步骤。
 * 2、每一个抽象模板角色都可以有任意多个具体模板角色与之对应，而每一个具体模板角色都可以给出这些抽象方法（也就是顶级逻辑的组成步骤）的不同实现，从而使得顶级逻辑的实现各不相同。
 * 
 * @author guanjm
 *
 */
public class ConcreteTemplateA extends AbstractTemplate {

	@Override
	void abstractMethod() {
		System.out.println(" this is abstractMethodA! ");
	}
	
	@Override
	void hookMethod() {
		System.out.println(" this is hookMethodA! ");
	}

}
