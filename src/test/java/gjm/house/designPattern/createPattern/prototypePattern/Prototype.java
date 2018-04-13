package gjm.house.designPattern.createPattern.prototypePattern;

/**
 * 原型模式（拷贝）
 * 
 * 条件
 * 1、实现cloneable接口（通知虚拟机可以安全地在实现了此接口的类上使用clone方法）
 * 2、重写Object类中的clone方法（默认protected类型，修改为public类型）
 * 
 * @author guanjm
 *
 */
public class Prototype implements Cloneable {
	
	private int id;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean equals(Prototype prototype) {
		return this.id == prototype.id;
	}
	
	/**
	 * 重写clone（公有public类型）
	 */
	public Prototype clone() {
		Prototype prototype = null;
		try {
			prototype = (Prototype) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return prototype;
	}
	
	/**
	 * 客户端
	 * @author guanjm
	 * @param args
	 */
	public static void main(String[] args) {
		
		//原始实体
		Prototype prototypeA = new Prototype();
		//克隆体
		Prototype prototypeB = prototypeA.clone();
		//对比内容
		System.out.println(" is equals :" + prototypeA.equals(prototypeB));
		//对比类
		System.out.println(" class is equals :" + prototypeA.getClass().equals(prototypeB.getClass()));
	}

}
