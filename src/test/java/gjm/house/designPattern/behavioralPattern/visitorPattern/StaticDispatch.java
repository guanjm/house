package gjm.house.designPattern.behavioralPattern.visitorPattern;

/**
 * 静态分派
 * @author guanjm
 *
 */
public class StaticDispatch {
	
	class Food{}
	
	class Fruit extends Food{}
	
	class Meat extends Food{}
	
	class Me{
		public void eat(Food food){
			System.out.println(" eat food ");
		}
		public void eat(Fruit fruit){
			System.out.println(" eat fruit ");
		}
		public void eat(Meat meat){
			System.out.println(" eat meat ");
		}
	}
	
	/**
	 * 结果：
	 *  eat food 
	 *  eat food 
	 * 
	 * @author guanjm
	 * @param args
	 */
	public static void main(String[] args){
		Food fruit = new StaticDispatch().new Fruit();
		Food meat = new StaticDispatch().new Meat();
		Me me = new StaticDispatch().new Me();
		me.eat(fruit);
		me.eat(meat);
	}
	
}
	
