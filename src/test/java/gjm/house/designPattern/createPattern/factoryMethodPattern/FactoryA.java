package gjm.house.designPattern.createPattern.factoryMethodPattern;

/**
 * 产品实现类
 * @author guanjm
 *
 */
public class FactoryA implements IFactory {

	@Override
	public IProduct produce() {
		return new ProductA();
	}

}
