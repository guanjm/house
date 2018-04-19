package gjm.house.designPattern.structuralPattern.flyweightPattern;

/**
 * 具体享元
 * 
 * 实现抽象享元角色所规定出的接口。如果有内蕴状态的话，必须负责为内蕴状态提供存储空间
 * 
 * @author guanjm
 *
 */
public class ConcreteFlyweight implements Flyweight {
	
	/**
	 * 内蕴状态
	 */
	private final String internalState;
	
	public ConcreteFlyweight(String internalState) {
		this.internalState = internalState;
	}

	@Override
	public void function(String externalState) {
		System.out.println(" this is " + internalState);
		System.out.println(" this is " + externalState);
	}


}
