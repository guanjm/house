package gjm.house.designPattern.createPattern.builderPattern;

/**
 * 建造者接口类
 * 
 * 1、建造/设置/加工/组建产品
 * 2、产出产品
 * 
 * @author guanjm
 *
 */
public interface IBuilder {
	
	/**
	 * 设置头部（组建产品）
	 * @author guanjm
	 * @param length
	 */
	public void setHead(String head);
	
	/**
	 * 设置躯干（组建产品）
	 * @author guanjm
	 * @param width
	 */
	public void setBody(String body);
	
	/**
	 * 设置四肢（组建产品）
	 * @author guanjm
	 * @param higth
	 */
	public void setLimbs(String limbs);
	
	/**
	 * 返回产品（必要：建造者就为了产出产品）
	 * @author guanjm
	 * @return
	 */
	public Product produce();

}
