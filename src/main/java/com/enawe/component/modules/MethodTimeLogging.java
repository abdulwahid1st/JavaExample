package com.enawe.component.modules;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/**
 *
 * example-springmvc
 * com.enawe.component > MethodTimeLogging.java
 * @author N Abdul Wh
 *
 * Aug 15, 2015 - 3:13:06 PM
 * 
 * Add additional log, see each methods doc for more details.
 */
@Aspect
@Component
public class MethodTimeLogging { 
	
	final static String COMPONENT_LOGGER = "ENAWE_COMPONENT_LOGGER_DEBUG";
	final static Logger logger = Logger.getLogger(COMPONENT_LOGGER);
	final static Logger logger2 = Logger.getLogger(MethodTimeLogging.class);

	/**
	 * @param invocation
	 * @return
	 * @throws Throwable
	 * 
	 * Add additional log: method's life time.
	 */
	@Around("@annotation(com.enawe.component.annotations.LogTime)")
	public Object logTime(ProceedingJoinPoint invocation) throws Throwable{
		if (logger.isDebugEnabled()){
			long start = System.currentTimeMillis();
			Object result = invocation.proceed(); // call the method
			long stop = System.currentTimeMillis();
			logger.debug("---"+start);
			logger.debug(invocation.getTarget().getClass().getSimpleName()+"."
					+invocation.getSignature().getName()+"()"
					+" -> time: " + (stop - start) + "ms");
			logger.debug("---"+stop);
			return result;
		} else {
			logger2.warn("to see additional log, enable debug for:"+COMPONENT_LOGGER);
			Object result = invocation.proceed();
			return result;
		}
	}
}
