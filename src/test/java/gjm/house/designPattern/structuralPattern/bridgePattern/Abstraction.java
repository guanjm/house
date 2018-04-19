package gjm.house.designPattern.structuralPattern.bridgePattern;

/**
 * 抽象类（桥接类）
 * 
 * 保持对实现类的引用
 * 
 * @author guanjm
 *
 */
public abstract class Abstraction {
	
	/**
	 * 行为实现类
	 * 对实现类的引用
	 */
	private Implementor implementor;
	
	public void setImplementor(Implementor implementor) {
		this.implementor = implementor;
	}
	
	/**
	 * 扩展的功能
	 * 
	 * @author guanjm
	 */
	public abstract void extendedFunction();

}
