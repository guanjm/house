package gjm.house.designPattern.structuralPattern.adapterPattern;

/**
 * 适配者模式
 * @author guanjm
 *
 */
public class Client {
	
	/**
	 * 客户端
	 * @author guanjm
	 * @param args
	 */
	public static void main(String[] args) {
		
		//类适配器
		Target classAdapter = new ClassAdapter();
		//适配器工作
		classAdapter.expectedFunction();
		
		//对象适配器（需要引入适配者对象实例）
		Target objectAdapter = new ObjectAdapter(new Adaptee());
		//适配器工作
		objectAdapter.expectedFunction();
	}

}
