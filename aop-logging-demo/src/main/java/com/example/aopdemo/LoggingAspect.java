package com.example.aopdemo;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Pointcut("within(@org.springframework.stereotype.Repository *)" +
            " || within(@org.springframework.stereotype.Service *)" +
            " || within(@org.springframework.web.bind.annotation.RestController *)")
    public void springStereotypes() {
    }

    @Pointcut("execution(* com.example.aopdemo..*(..))")
    public void applicationPackage() {
    }

    @AfterThrowing(pointcut = "applicationPackage()", throwing = "e")
    public void logAfterThrowing(JoinPoint jp, Throwable e) {
        log.error("Exception in {}.{}() with cause = {}",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(),
                e.getCause() != null ? e.getCause() : "NULL", e);
    }

    @Around("applicationPackage()")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        if (log.isDebugEnabled()) {
            log.debug("Enter: {}.{}() with args = {}",
                    pjp.getSignature().getDeclaringTypeName(),
                    pjp.getSignature().getName(),
                    java.util.Arrays.toString(pjp.getArgs()));
        }
        Object result = pjp.proceed();
        if (log.isDebugEnabled()) {
            log.debug("Exit: {}.{}() with result = {}",
                    pjp.getSignature().getDeclaringTypeName(),
                    pjp.getSignature().getName(),
                    result);
        }
        return result;
    }


}
