package gjm.house.designPattern.createPattern.builderPattern;

/**
 * 产品类
 * @author guanjm
 *
 */
public class Product {
	
	/**
	 * 头部
	 */
	private String head;
	
	/**
	 * 躯干
	 */
	private String body;
	
	/**
	 * 四肢
	 */
	private String limbs;

	public void setHead(String head) {
		this.head = head;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setLimbs(String limbs) {
		this.limbs = limbs;
	}

	public void function() {
		System.out.println(" this is product ");
		System.out.println(head);
		System.out.println(body);
		System.out.println(limbs);
	}
}
