package gjm.house.designPattern.createPattern.staticFactoryPattern;

/**
 * 工厂实现类
 * @author guanjm
 *
 */
public class Factory {
	
	/**
	 * 产品编号
	 * @author guanjm
	 *
	 */
	enum ProductNo{
		productA,
		productB
	}
	
	/**
	 * 生成产品
	 * @author guanjm
	 * @param productNo
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static IProduct produce(ProductNo productNo) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		/*switch(productNo) {
			case productA : return new ProductA();
			case productB : return new ProductB();
			default : return null;
		}*/
		
		//使用类的反射来构建对象
		switch(productNo) {
			case productA : 
				return (IProduct) Class.forName(ProductA.class.getName()).newInstance();
			case productB : 
				return (IProduct) Class.forName(ProductB.class.getName()).newInstance();
			default : 
				return null;
		}
	}

}
