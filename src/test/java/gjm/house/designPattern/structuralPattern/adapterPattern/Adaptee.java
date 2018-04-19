package gjm.house.designPattern.structuralPattern.adapterPattern;

/**
 * 适配者角色（被适配的接口）
 * @author guanjm
 *
 */
public class Adaptee {
	
	/**
	 * 非期待的接口
	 * @author guanjm
	 */
	public void unexpectedFunction() {
		System.out.println(" output result! ");
	}

}
