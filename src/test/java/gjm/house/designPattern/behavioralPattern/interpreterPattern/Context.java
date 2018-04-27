package gjm.house.designPattern.behavioralPattern.interpreterPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 环境
 * 
 * 这个角色的任务一般是用来存放文法中各个终结符所对应的具体值
 * （比如R=R1+R2，我们给R1赋值100，给R2赋值200，些信息需要存放到环境角色中，很多情况下我们使用Map来充当环境角色就足够了）
 * 
 * @author guanjm
 *
 */
public class Context {
	
	/**
	 * 缓存数字终结符
	 */
	private Map<String, Object> numberMap = new HashMap<String, Object>();
	
	/**
	 * 缓存字母终结符
	 */
	private Map<String, Object> charMap = new HashMap<String, Object>();
	
	/**
	 * 存入终结符
	 * @author guanjm
	 * @param key
	 * @param value
	 */
	public void assign(String key, Object value) {
		if(value instanceof Integer) {
			numberMap.put(key, (Integer)value);
		} else if (value instanceof Character) {
			charMap.put(key, (Character)value);
		}
	}
	
	/**
	 * 获取终结符
	 * @author guanjm
	 * @param key
	 * @return
	 */
	public Object lookup(Object key) {
		Object object;
		if((object = numberMap.get(key)) != null) {
			return object;
		} else if((object = charMap.get(key)) != null) {
			return object;
		}
		return null;
	}

}
