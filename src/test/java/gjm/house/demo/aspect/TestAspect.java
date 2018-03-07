package gjm.house.demo.aspect;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import javax.annotation.Resource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * aop面向切面
 * @author guanjm
 *
 */
@Aspect	//指定当前类为切面类（先在spring-mvc.xml配置开启aop代理）
@Component	//加入到IoC容器
public class TestAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(TestAspect.class);
	
	/**
	 * 切入点
	 * @author guanjm
	 */
	@Pointcut("execution(* gjm.house.*.controller.*.*(..))")
	private void controllerAspect(){
		
	}
	
	/**
	 * 环绕触发
	 * @author guanjm
	 * @param pjp
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws Throwable
	 */
	@Around("controllerAspect()")
	public Object around(ProceedingJoinPoint pjp){
		
        //拦截的实体类，就是当前正在执行的controller
		Object target = pjp.getTarget();
		// 拦截的方法名称。当前正在执行的方法
		String methodName = pjp.getSignature().getName();
		// 拦截的方法参数
		Object[] args = pjp.getArgs();
        //拦截的放参数类型
        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Class[] parameterTypes = msig.getMethod().getParameterTypes();
        
        // 获得被拦截的方法
        Method method = null;
        try {
        	method = target.getClass().getMethod(methodName, parameterTypes);
        } catch (Exception e) {
        	logger.error("TestAspect around error: ", e);
        }
        
        //TODO 方法执行前操作
        System.out.println("--------方法执行前！--------");
        
        Object result = null;
		try {
			//方法执行
			result = pjp.proceed();
		} catch (Throwable e) {
			logger.error("TestAspect around pjp.proceed() error: ", e);
		}
		
		//TODO 方法执行后操作
		System.out.println("--------方法执行后！--------");
		
		return result;
	}
	
}
