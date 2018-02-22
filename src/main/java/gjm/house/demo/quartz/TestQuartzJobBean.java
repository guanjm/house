package gjm.house.demo.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestQuartzJobBean {
	
	private static Logger log = LoggerFactory.getLogger(TestQuartzJobBean.class);
	
	public void execute(){
		log.error("----------测试定时任务成功~~~----------");
	}

}
