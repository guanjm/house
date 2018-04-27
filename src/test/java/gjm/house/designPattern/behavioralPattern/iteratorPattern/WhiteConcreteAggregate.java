package gjm.house.designPattern.behavioralPattern.iteratorPattern;

/**
 * 具体聚集（白箱聚集）
 * 如果一个聚集的接口提供了可以用来修改聚集元素的方法，这个接口就是所谓的宽接口
 * 这种提供宽接口的聚集叫做白箱聚集
 * 
 * 实现了聚集对象的接口，返回一个合适的具体迭代子实例
 * 还有方法getElement()向外界提供聚集元素，而方法size()向外界提供聚集的大小等
 * 
 * @author guanjm
 *
 */
public class WhiteConcreteAggregate implements Aggregate {
	
	/**
	 * 持有具体元素
	 */
	private Object[] values;
	
	/**
	 * 构造方法
	 * @param objectArray 聚集具体元素
	 */
	public WhiteConcreteAggregate(Object[] objectArray) {
		this.values = objectArray;
	}

	@Override
	public Iterator createIterator() {
		return new ExtrinsicIterator(this);
	}
	
	/**
	 * 返回指定的元素
	 * @author guanjm
	 * @param index 序号
	 * @return
	 */
	public Object get(int index) {
		if(index < values.length) {
			return values[index];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * 返回聚集的大小
	 * @author guanjm
	 * @return
	 */
	public int size() {
		return values.length;
	}

}
