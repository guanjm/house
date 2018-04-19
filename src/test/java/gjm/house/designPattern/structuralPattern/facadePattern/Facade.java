package gjm.house.designPattern.structuralPattern.facadePattern;

/**
 * 外观类
 * @author guanjm
 *
 */
public class Facade {
	
	/**
	 * 功能统一入口
	 * 集齐所需功能调用的方法
	 * 
	 * @author guanjm
	 */
	public static void function() {
		SubSystemA.function();
		SubSystemB.function();
	}

}
