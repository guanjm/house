package gjm.house.demo.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestQuartzJobBean {
	
	private static final Logger logger = LoggerFactory.getLogger(TestQuartzJobBean.class);
	
	public void execute(){
		logger.error("----------测试定时任务成功~~~----------");
	}

}
