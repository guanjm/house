package gjm.house.common.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(ListUtil.class);
	
	public static <T> List<T> turn(List<Object> targetList, Class<T> clazz) {
		try {
			if(targetList != null && !targetList.isEmpty()) {
				List<T> result = new ArrayList<T>();
				Object object = targetList.get(0);
				if(object instanceof BigDecimal || object instanceof Integer) {
					for(Object obj : targetList) {
						result.add((T) obj.toString());
					}
					return result;
				} else {
					for(Object obj : targetList) {
						result.add((T)obj);
					}
					return result;
				}
			}
		} catch (Exception e) {
			logger.error(" ListUtil turn error:{} ", e);
		}
		return Collections.emptyList();
	}

}
