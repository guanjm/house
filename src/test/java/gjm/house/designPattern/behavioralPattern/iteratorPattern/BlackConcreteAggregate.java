package gjm.house.designPattern.behavioralPattern.iteratorPattern;

/**
 * 具体聚集（黑箱聚集）
 * 如果一个聚集的接口没有提供修改聚集元素的方法，这样的接口就是所谓的窄接口
 * 
 * @author guanjm
 *
 */
public class BlackConcreteAggregate implements Aggregate {
	
	/**
	 * 持有具体元素
	 */
	private Object[] values;
	
	/**
	 * 构造方法
	 * @param objectArray 具体聚集元素
	 */
	public BlackConcreteAggregate(Object[] objectArray) {
		this.values = objectArray;
	}

	@Override
	public Iterator createIterator() {
		return new IntrinsicIterator();
	}
	
	/**
	 * 具体聚（集内禀迭代子（Intrinsic Iterator））
	 * 
	 * @author guanjm
	 *
	 */
	private class IntrinsicIterator implements Iterator {
		
		/**
		 * 内部索引，记录当前迭代的索引位置
		 */
		private int index;

		@Override
		public void first() {
			index = 0;
		}

		@Override
		public void next() {
			if(index < values.length) {
				index ++;
			}
		}

		@Override
		public boolean isDone() {
			return index == values.length;
		}

		@Override
		public Object currentItem() {
			return values[index];
		}
		
	} 

}
