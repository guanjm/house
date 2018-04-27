package gjm.house.designPattern.behavioralPattern.visitorPattern;

/**
 * 抽象节点
 * 
 * 声明一个接受操作，接受一个访问者对象作为一个参数。
 * 
 * @author guanjm
 *
 */
public interface Node {
	
	/**
	 * 接受操作
	 * @author guanjm
	 * @param visitor
	 */
	public void accept(Visitor visitor);

}
