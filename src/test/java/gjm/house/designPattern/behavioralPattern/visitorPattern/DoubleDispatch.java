package gjm.house.designPattern.behavioralPattern.visitorPattern;

/**
 * 双重分派
 * @author guanjm
 *
 */
public class DoubleDispatch {
	
	interface IWest{
		public void goWest(East1 east);
		public void goWest(East2 east);
	}
	class West1 implements IWest{
		@Override
		public void goWest(East1 east) {
			System.out.print(" this is West1 + ");
			east.print();
		}
		@Override
		public void goWest(East2 east) {
			System.out.print(" this is West1 + ");
			east.print();
		}
	}
	class West2 implements IWest{
		@Override
		public void goWest(East1 east) {
			System.out.print(" this is West2 + ");
			east.print();
		}
		@Override
		public void goWest(East2 east) {
			System.out.print(" this is West2 + ");
			east.print();
		}
	}
	
	interface IEast{
		public void goEast(IWest west);
	}
	class East1 implements IEast{
		@Override
		public void goEast(IWest west) {
			west.goWest(this);
		}
		public void print() {
			System.out.println(" this is East1 ");
		}
	}
	class East2 implements IEast{
		@Override
		public void goEast(IWest west) {
			west.goWest(this);
		}
		public void print() {
			System.out.println(" this is East2 ");
		}
	}
	
	/**
	 * 结果：
	 *  this is West1 +  this is East1 
	 *  this is West2 +  this is East1 
	 *  this is West1 +  this is East2 
	 *  this is West2 +  this is East2 
	 * 
	 * @author guanjm
	 * @param args
	 */
	public static void main(String[] args) {
		
		IEast east;
		IWest weat;
		DoubleDispatch client = new DoubleDispatch();
		
		//宗量：East1对象为接受对象，West1为方法参数
		//East1对象为接受对象，该为动态分派
		//West1为方法参数，内部实现其实：West1作为内部方法的接受对象，该为动态分派
		east = client.new East1();
		weat = client.new West1();
		east.goEast(weat);
		
		//宗量：East1对象为接受对象，West2为方法参数
		east = client.new East1();
		weat = client.new West2();
		east.goEast(weat);
		
		//宗量：East2对象为接受对象，West1为方法参数
		east = client.new East2();
		weat = client.new West1();
		east.goEast(weat);
		
		//宗量：East2对象为接受对象，West2为方法参数
		east = client.new East2();
		weat = client.new West2();
		east.goEast(weat);
	}

}
