package gjm.house.designPattern.behavioralPattern.iteratorPattern;

/**
 * 迭代器模式/游标模式
 * 
 * 两种实现方式：白箱聚集与外禀迭代子/黑箱聚集于内禀迭代子
 * 
 * 
 * @author guanjm
 *
 */
public class Client {
	
	/**
	 * 客户端
	 * @author guanjm
	 * @param args
	 */
	public static void main(String[] args) {
		
		//设置聚类具体内容
		Object[] objectArray = new Object[] {0, 1, 2, 3, 4, 5};
		
		//创建白箱聚集实例对象
		Aggregate whiteConcreteAggregate = new WhiteConcreteAggregate(objectArray);
		//通过具体聚类实例获取外禀迭代器
		Iterator extrinsicIterator = whiteConcreteAggregate.createIterator();
		//遍历具体聚集实例对象
		for(;!extrinsicIterator.isDone();extrinsicIterator.next()) {
			System.out.println(extrinsicIterator.currentItem());
		}
		//指向第一个元素
		extrinsicIterator.first();
		System.out.println(extrinsicIterator.currentItem());
		
		System.out.println("------------------split line-----------------");
		
		//创建黑箱聚集实例对象
		Aggregate blackconcreteAggregate = new BlackConcreteAggregate(objectArray);
		//通过具体聚类实例获取内禀迭代器
		Iterator intrinsicIterator = blackconcreteAggregate.createIterator();
		//遍历具体聚集实例对象
		for(;!intrinsicIterator.isDone();intrinsicIterator.next()) {
			System.out.println(intrinsicIterator.currentItem());
		}
		//指向第一个元素
		intrinsicIterator.first();
		System.out.println(intrinsicIterator.currentItem());
	}

}
