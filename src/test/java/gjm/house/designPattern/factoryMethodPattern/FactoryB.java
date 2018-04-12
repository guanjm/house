package gjm.house.designPattern.factoryMethodPattern;

/**
 * 工厂实现类
 * @author guanjm
 *
 */
public class FactoryB implements IFactory {

	@Override
	public IProduct produce() {
		return new ProductB();
	}

}
