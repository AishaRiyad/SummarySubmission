package com.example.taskflow.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.example.taskflow.service..*(..)) || " +
            "execution(* com.example.taskflow.controller..*(..))")
    public Object logExecution(ProceedingJoinPoint pjp) throws Throwable {
        String method = pjp.getSignature().toShortString();
        log.debug("Enter: {} with args = {}", method, pjp.getArgs());
        long start = System.currentTimeMillis();
        try {
            Object result = pjp.proceed();
            long time = System.currentTimeMillis() - start;
            log.debug("Exit: {} with result = {} ({} ms)", method, result, time);
            return result;
        } catch (Throwable ex) {
            log.error("Exception in {}: {}", method, ex.getMessage());
            throw ex;
        }
    }
}
