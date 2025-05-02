package com.recruitment.applicantservice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.recruitment.applicantservice.controller..*(..)) || execution(* com.recruitment.applicantservice.service..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Entering method: {}.{} with arguments {}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "execution(* com.recruitment.applicantservice.controller..*(..)) || execution(* com.recruitment.applicantservice.service..*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        logger.info("Exiting method: {}.{} with result {}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), result);
    }
}