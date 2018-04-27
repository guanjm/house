package gjm.house.designPattern.behavioralPattern.iteratorPattern;

/**
 * 聚集
 * 
 * 定义创建相应迭代器对象的接口
 * 必须有一个工厂方法，也就是createIterator()方法，以向外界提供迭代子对象的实例
 * 
 * @author guanjm
 *
 */
public interface Aggregate {
	
	/**
	 * 创建迭代器实例对象
	 * @author guanjm
	 * @return
	 */
	public Iterator createIterator();
}
