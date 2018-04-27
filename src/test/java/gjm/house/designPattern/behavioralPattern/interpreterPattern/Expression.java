package gjm.house.designPattern.behavioralPattern.interpreterPattern;

/**
 * 抽象表达式
 * 
 * 声明一个所有的具体表达式角色都需要实现的抽象接口。
 * 这个接口主要是一个interpret()方法，称做解释操作
 * 
 * @author guanjm
 *
 */
public interface Expression {
	
	/**
	 * 解释操作
	 * @author guanjm
	 * @return
	 */
	public Object interpret(Context context);

}
