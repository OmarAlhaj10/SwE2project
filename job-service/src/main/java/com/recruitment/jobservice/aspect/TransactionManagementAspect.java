package com.recruitment.jobservice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import org.springframework.beans.factory.annotation.Autowired;

@Aspect
@Component
public class TransactionManagementAspect {
    private static final Logger logger = LoggerFactory.getLogger("job-service-transaction-log");

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Pointcut("execution(* com.recruitment.jobservice.service..*(..))")
    public void serviceMethods() {}

    @Around("serviceMethods()")
    public Object manageTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName(joinPoint.getSignature().toShortString());
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            Object result = joinPoint.proceed();
            transactionManager.commit(status);
            logger.info("Transaction committed for method {}", joinPoint.getSignature().getName());
            return result;
        } catch (Exception ex) {
            transactionManager.rollback(status);
            logger.error("Transaction rolled back for method {} due to exception: {}", joinPoint.getSignature().getName(), ex.getMessage());
            throw ex;
        }
    }
}