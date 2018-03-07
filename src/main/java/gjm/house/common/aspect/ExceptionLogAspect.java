package gjm.house.common.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 自动记录异常日志
 * @author guanjm
 *
 */
@Aspect
@Component
public class ExceptionLogAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionLogAspect.class);
	
	/**
	 * 切入点
	 * @author guanjm
	 */
	@Pointcut("execution(* gjm.house..*.*(..))")
	private void ExceptionAspect() {
		
	}
	
	/**
	 * 异常处理advice
	 * @author guanjm
	 * @param e
	 */
	@SuppressWarnings("rawtypes")
	@AfterThrowing(pointcut = "ExceptionAspect()" ,throwing = "e")
	public void afterThrowing(JoinPoint joinPoint, Throwable e) {
		//异常时间
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		logger.error("error Date：{}", date);
		
		//异常请求url
		String url = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).
				getRequest().getRequestURL().toString();
		logger.error("error request URL：{}", url);
		
		//目标对象名
		String className = joinPoint.getTarget().getClass().getName();
		logger.error("error className：{}", className);
		
		//目标方法名
		String method = joinPoint.getSignature().getName();
		logger.error("error method：{}", method);
		
		//目标方法实参
		Object[] args = joinPoint.getArgs();
		//目标方法形参
        Signature sig = joinPoint.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Class[] parameterTypes = msig.getMethod().getParameterTypes();
        StringBuffer methodArgs = new StringBuffer();
        for(int i=0; i<parameterTypes.length; i++) {
        	methodArgs.append("\tat ").append(parameterTypes[i].getName()).append(" : ").append(args[i]).append("\r\n");
        }
        logger.error("error methodArgs：{}", methodArgs);
        
        //异常详细信息
  		StringBuffer errorMsg = new StringBuffer();
  		StackTraceElement[] stackTrace = e.getStackTrace();
  		for(StackTraceElement element : stackTrace) {
  			errorMsg.append("\tat ").append(element).append("\r\n");
  		}
  		logger.error("error message：{}", errorMsg);
		
	}

}
