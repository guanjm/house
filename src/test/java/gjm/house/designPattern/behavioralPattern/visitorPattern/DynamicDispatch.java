package gjm.house.designPattern.behavioralPattern.visitorPattern;

/**
 * 动态分派
 * @author guanjm
 *
 */
public class DynamicDispatch {
	
	class Food{
		public void eat() {
			System.out.println(" eat food ");
		}
	}
	
	class Fruit extends Food {
		public void eat() {
			System.out.println(" eat fruit ");
		}
	}
	
	class Meat extends Food {
		public void eat() {
			System.out.println(" eat food ");
		}
	}
	
	/**
	 * 输出结果：
	 * eat fruit
	 * eat meat
	 * 
	 * @author guanjm
	 * @param args
	 */
	public static void main(String[] args) {
		Food fruit = new DynamicDispatch().new Fruit();
		Food meat = new DynamicDispatch().new Meat();
		fruit.eat();
		meat.eat();
	}

}
