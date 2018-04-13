package gjm.house.designPattern.createPattern.abstractFactoryPattern;

/**
 * 工厂接口类
 * @author guanjm
 *
 */
public interface IFactory {
	
	/**
	 * 提供产品指引
	 * @author guanjm
	 * @return
	 */
	public IInstruction provide();
	
	/**
	 * 生产产品
	 * @author guanjm
	 * @return
	 */
	public IProduct produce();

}
