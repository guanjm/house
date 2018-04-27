package gjm.house.designPattern.behavioralPattern.statePattern;

/**
 * 抽象状态
 * 
 * 定义一个接口，用以封装环境（Context）对象的一个特定的状态所对应的行为。
 * 
 * @author guanjm
 *
 */
public interface State {
	
	/**
	 * 状态对应的处理
	 * @author guanjm
	 * @param context	环境（方便回调上下文的数据）
	 */
	public void handle(Context context);

}
