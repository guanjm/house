package gjm.house.designPattern.abstractFactoryPattern;

/**
 * 工厂实现类
 * @author guanjm
 *
 */
public class FactoryA implements IFactory {
	
	@Override
	public IInstruction provide() {
		return new InstructionA();
	}

	@Override
	public IProduct produce() {
		return new ProductA();
	}

}
