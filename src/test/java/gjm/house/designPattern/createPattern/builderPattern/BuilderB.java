package gjm.house.designPattern.createPattern.builderPattern;

/**
 * 建造者实现类（制造出来的东西带+）
 * @author guanjm
 *
 */
public class BuilderB implements IBuilder {
	
	/**
	 * 必要
	 * 产品实例（一个空的架构）
	 */
	private Product product = new Product();

	@Override
	public void setHead(String head) {
		product.setHead("+++++++++" + head + "+++++++");
	}

	@Override
	public void setBody(String body) {
		product.setBody("+++++++" + body + "+++++++");
	}

	@Override
	public void setLimbs(String limbs) {
		product.setLimbs("++++++++" + limbs + "+++++++");
	}
	
	@Override
	public Product produce() {
		return product;
	}

}
