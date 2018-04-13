package gjm.house.designPattern.createPattern.builderPattern;

import gjm.house.designPattern.createPattern.builderPattern.Director.ProductNo;

/**
 * 建造者模式
 * 
 * 典型例子StringBuilder
 * Director通过建造者实现类创建产品，调用其方法自定义想要的产产品，调用其方法返回最终的产品
 * （不易扩展，需要修改主管类）
 * 
 * 只生产一类产品（Product）
 * 不同的产品由由主管来组建
 * 
 * @author guanjm
 *
 */
public class Client {
	
	public static void main(String[] args) {
		
		//向主管要求生产产品A
		Product productA = Director.getProduct(ProductNo.productA);
		//产品A工作
		productA.function();
		System.out.println();
		
		//向主管要求生产产品B
		Product productB = Director.getProduct(ProductNo.productB);
		//产品B工作
		productB.function();
		System.out.println();
		
		//向主管要求生产产品C
		Product productC = Director.getProduct(ProductNo.productC);
		//产品Ds工作
		productC.function();
		System.out.println();
		
		//向主管要求生产产品D
		Product productD = Director.getProduct(ProductNo.productD);
		//产品D工作
		productD.function();
		
	}

}
