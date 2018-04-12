package gjm.house.designPattern.staticFactoryPattern;

import gjm.house.designPattern.staticFactoryPattern.Factory.ProductNo;

/**
 * 静态工厂模式
 * 事先明确生产工厂需要做的事
 * （不易扩展，需要修改工厂类）
 * 
 * 唯一的工厂实现类能生产不同的产品
 * 唯一的工厂实现类只能生产一类产品（IProduct）
 * 
 * @author guanjm
 *
 */
public class Client {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		//唯一的工厂生产的产品A
		IProduct productA = Factory.produce(ProductNo.productA);
		//产品A工作
		productA.function();
		
		//唯一的工厂生产的产品B
		IProduct productB = Factory.produce(ProductNo.productB);
		//产品B工作
		productB.function();
	}

}
