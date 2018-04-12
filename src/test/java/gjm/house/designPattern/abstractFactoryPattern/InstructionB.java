package gjm.house.designPattern.abstractFactoryPattern;

/**
 * 产品指引实现类
 * @author guanjm
 *
 */
public class InstructionB implements IInstruction {

	@Override
	public void instruct() {
		System.out.println(" use productB like this! ");
	}

}
