package gjm.house.designPattern.structuralPattern.adapterPattern;

/**
 * 类适配器
 * @author guanjm
 *
 */

//适配器Adapter继承自适配者Adaptee，同时又实现了目标(Target)接口。
public class ClassAdapter extends Adaptee implements Target {

	/**
	 * 将适配者的方法封装成适配器的方法（将需要调用的方法封装成期待调用的形式）
	 */
	@Override
	public void expectedFunction() {
		this.unexpectedFunction();
	}
	
}
