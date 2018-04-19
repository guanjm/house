package gjm.house.designPattern.structuralPattern.adapterPattern;

/**
 * 对象适配器
 * @author guanjm
 *
 */
public class ObjectAdapter implements Target {
	
	/**
	 * 适配者（被适配的接口）
	 */
	private Adaptee adaptee;
	
	/**
	 * 通过构造方法传入具体需要适配的适配者
	 * @param adaptee
	 */
	public ObjectAdapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	/**
	 * 将适配者的方法封装成适配器的方法（将需要调用的方法封装成期待调用的形式）
	 */
	public void expectedFunction() {
		this.adaptee.unexpectedFunction();
	}

}
