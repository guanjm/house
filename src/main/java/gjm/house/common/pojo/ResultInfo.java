package gjm.house.common.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 输出规范
 * @author guanjm
 *
 */
public class ResultInfo {
	
	/**
	 * 状态
	 */
	private Integer status;
	
	/**
	 * 消息
	 */
	private String msg;
	
	/**
	 * 数据
	 */
	private Object data;
	
	public ResultInfo(Integer status, String msg, Object data){
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 转json格式的String
	 */
	public String toJsonString(){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			StringBuilder str = new StringBuilder(" { ");
			str.append(" \"code\" : \"-1\", ");
			str.append(" \"msg\" : \"转化json失败\", ");
			str.append(" \"data\" : \"操作失败，请联系管理员\" ");
			str.append(" } ");
			return str.toString();
		}
	}
	
}
