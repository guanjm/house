package gjm.house.designPattern.structuralPattern.compositePattern;

/**
 * 抽象构件
 * @author guanjm
 *
 */
public interface Component {
	
	/**
	 * 增加构件
	 * @author guanjm
	 * @param component
	 */
	public void add(Component component);
	
	/**
	 * 删除构件
	 * @author guanjm
	 * @param component
	 */
	public void remove(Component component);
	
	/**
	 * 获取子构件
	 * @author guanjm
	 * @return
	 */
	public Component getChild(int i);
	
	/**
	 * 功能
	 * @author guanjm
	 */
	public void operation();

}
