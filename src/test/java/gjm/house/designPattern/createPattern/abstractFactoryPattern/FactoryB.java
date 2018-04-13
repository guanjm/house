package gjm.house.designPattern.createPattern.abstractFactoryPattern;

/**
 * 工厂实现类
 * @author guanjm
 *
 */
public class FactoryB implements IFactory {
	
	@Override
	public IInstruction provide() {
		return new InstructionB();
	}

	@Override
	public IProduct produce() {
		return new ProductB();
	}

}
