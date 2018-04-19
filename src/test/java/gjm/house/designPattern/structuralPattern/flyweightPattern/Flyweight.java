package gjm.house.designPattern.structuralPattern.flyweightPattern;

/**
 * 抽象享元
 * 
 * 给出一个抽象接口，以规定出所有具体享元角色需要实现的方法
 * 
 * @author guanjm
 *
 */
public interface Flyweight {
	
	/**
	 * 功能
	 * @author guanjm
	 * @param externalState	外蕴状态
	 */
	public void function(String externalState);

}
