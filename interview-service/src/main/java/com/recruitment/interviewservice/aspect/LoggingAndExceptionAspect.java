package com.recruitment.interviewservice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAndExceptionAspect {
    private static final Logger logger = LoggerFactory.getLogger("interview-service-log");

    @Pointcut("execution(* com.recruitment.interviewservice.service..*(..))")
    public void serviceMethods() {}

    @Around("serviceMethods()")
    public Object logAndHandleException(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().getName();
        try {
            Object result = joinPoint.proceed();
            long timeTaken = System.currentTimeMillis() - start;
            logger.info("Method {} executed successfully in {} ms.", methodName, timeTaken);
            return result;
        } catch (Exception ex) {
            logger.error("Exception in method {}: {}", methodName, ex.getMessage());
            throw ex;
        }
    }
}