package com.springers.ASPECTS;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

	@Before("execution(* com.springers.SERVICES.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Object[] args = joinPoint.getArgs();
        logger.info("Entering method " + methodName + " in class " + className);
        logger.debug("Entering method " + methodName + " in class " + className);
        logger.debug("Method arguments: " + Arrays.toString(args));
        logger.debug("Timestamp: " + LocalDateTime.now());
    }

    @AfterReturning(pointcut = "execution(* com.springers.SERVICES.*.*(..))", returning = "result")
    public void logMethodExit(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Exiting method " + methodName);
        logger.debug("Exiting method " + methodName);
        logger.debug("Method return value: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.springers.SERVICES.*.*(..))", throwing = "exception")
    public void logException(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Exception in method " + methodName + ": " + exception.getMessage());
    }

}
