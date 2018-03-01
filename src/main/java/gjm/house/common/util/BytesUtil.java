package gjm.house.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 字节化工具
 * @author Tim
 *
 */
public class BytesUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(BytesUtil.class);
	
	/**
	 * 对象转成字节数组
	 * @param object
	 * @return null：转化失败
	 */
	public static byte[] turnByteArray(Object object) {
		ByteArrayOutputStream bos;
		ObjectOutputStream oos;
		byte[] result = null;
		try {
			if(object != null) {
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
			}
		} catch (Exception e) {
			logger.error(" BytesUtil turnByteArray error:{} param:{}", e, object);
		}
		return result;
	}
	
	/**
	 * 字节数组转成对象
	 * @param byteArray
	 * @param clazz 目标对象数据类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T turnObject(byte[] byteArray, Class<T> clazz) {
		ByteArrayInputStream bis;
		ObjectInputStream ois;
		T result = null;
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
			logger.error(" BytesUtil turnObject error:{} param:{}", e.getStackTrace(), byteArray);
		}
		return result;
	}
	
	/**
	 * 可变对象数组转2维字节数组（未完成）
	 * @param object
	 * @return null：转化失败
	 */
	@Deprecated
	public static byte[][] turn2DByteArray(Object...object) {
		try {
			if(object == null) {
				throw new Exception("BytesUtil turn2DByteArray params can't null !");
			}
			byte[][] result = new byte[object.length][];
			for (int i = 0; i < object.length; i++) {
				result[i] = turnByteArray(object[i]);
			}
			return result;
		} catch (Exception e) {
			logger.error(" BytesUtil turn2DByteArray error:{} params:{}", e, object);
		}
		return null;
	}
	
}
