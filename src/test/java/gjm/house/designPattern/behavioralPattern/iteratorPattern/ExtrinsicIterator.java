package gjm.house.designPattern.behavioralPattern.iteratorPattern;

/**
 * 具体迭代器
 * 由于聚集自己实现迭代逻辑，并向外部提供适当的接口，使得迭代子可以从外部控制聚集元素的迭代过程
 * 这样一来迭代子所控制的仅仅是一个游标而已，这种迭代子叫做游标迭代子（Cursor Iterator）
 * 由于迭代子是在聚集结构之外的，因此这样的迭代子又叫做外禀迭代子（Extrinsic Iterator）
 * 
 * 实现了迭代器接口，并保持迭代过程中的游标位置
 * 
 * @author guanjm
 *
 */
public class ExtrinsicIterator implements Iterator {
	
	/**
	 * 持有具体聚集对象
	 */
	private WhiteConcreteAggregate aggregate;
	
	/**
	 * 内部索引，记录当前迭代的索引位置
	 */
	private int index;
	
	/**
	 * 构造方法
	 * @param aggregate	具体聚集对象
	 */
	public ExtrinsicIterator(WhiteConcreteAggregate aggregate) {
		this.aggregate = aggregate;
	}

	@Override
	public void first() {
		this.index = 0;
	}

	@Override
	public void next() {
		if(index < aggregate.size()) {
			index ++;
		}
	}

	@Override
	public boolean isDone() {
		return index == aggregate.size();
	}

	@Override
	public Object currentItem() {
		return aggregate.get(index);
	}

}
