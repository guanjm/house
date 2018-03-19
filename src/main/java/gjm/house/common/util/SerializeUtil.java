package gjm.house.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 序列化工具
 * @author guanjm
 *
 */
public class SerializeUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(SerializeUtil.class);
	
	/**
	 * 序列化
	 * @author guanjm
	 * @param object
	 * @return	null:序列化失败
	 */
	public static byte[] serialize(Object object) {
		if(object == null) {
			throw new NullPointerException("SerializeUtil serialize arg can't be null");
		}
		byte[] result = null;
		ByteArrayOutputStream bos;
		ObjectOutputStream oos;
		try {
			if(object instanceof String) {
				result = ((String) object).getBytes("UTF-8");
			} else {
				bos = new ByteArrayOutputStream();
				oos = new ObjectOutputStream(bos);
				oos.writeObject(object);
				result = bos.toByteArray();
				bos.close();
				oos.close();
			}
		} catch (Exception e) {
			logger.error(" SerializeUtil serialize error:{} \r\n arg:{} ", e, object);
		}
		return result;
	}
	
	/**
	 * 反序列化
	 * @param byteArray
	 * @param clazz 目标对象数据类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deserialize(byte[] byteArray, Class<T> clazz) {
		T result = null;
		ByteArrayInputStream bis;
		ObjectInputStream ois;
		try {
			if(byteArray != null) {
				if(clazz.newInstance() instanceof String) {
					result = (T) new String(byteArray);
				} else {
					bis = new ByteArrayInputStream(byteArray);
					ois = new ObjectInputStream(bis);
					result = (T) ois.readObject();
					bis.close();
					ois.close();
				}
			}
		} catch (Exception e) {
			logger.error(" SerializeUtil deserialize error:{} \r\n arg:{} ", e, byteArray);
		}
		return result;
	}
	
}
