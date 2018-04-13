package gjm.house.designPattern.createPattern.builderPattern;

/**
 * 主管类
 * 
 * 一般不需要这个类
 * 
 * @author guanjm
 *
 */
public class Director {
	
	//产品编号
	enum ProductNo{
		productA,	//开心-
		productB,	//不开心-
		productC,	//开心+
		productD	//不开心+
	}
	
	//得到产品
	public static Product getProduct(ProductNo productNo) {
		
		switch(productNo) {
			case productA : {
				//指定建造者实现类A（-）
				IBuilder builderA = new BuilderA();
				//组装产品A
				builderA.setHead("(*^▽^*)");
				builderA.setBody("(づ          )づ");
				builderA.setLimbs("|  \\");
				//产出产品A
				return builderA.produce();
			}
			case productB : {
				//指定建造者实现类A（-）
				IBuilder builderB = new BuilderA();
				//组装产品B
				builderB.setHead("￣へ￣");
				builderB.setBody("（╯    ）╯");
				builderB.setLimbs("|  |");
				//产出产品B
				return builderB.produce();
			}
			case productC : {
				//指定建造者实现类B（+）
				IBuilder builderC = new BuilderB();
				//组装产品C
				builderC.setHead("(*^▽^*)");
				builderC.setBody("(づ          )づ");
				builderC.setLimbs("|  \\");
				//产出产品C
				return builderC.produce();
			}
			case productD : {
				//指定建造者实现类B（+）
				IBuilder builderD = new BuilderB();
				//组装产品D
				builderD.setHead("￣へ￣");
				builderD.setBody("（╯    ）╯");
				builderD.setLimbs("|  |");
				//产出产品D
				return builderD.produce();
			}
			default : return null;
		}
	}

}
