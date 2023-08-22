package com.codeverse.code_verse_uni.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ApplicationLoggingAspect {

    @Pointcut("execution(*  com.codeverse.code_verse_uni.controller.*.*(..))")
    public void forControllerPackage(){}

    @Pointcut("execution(*  com.codeverse.code_verse_uni.service.*.*(..))")
    public void forServicePackage(){}

    @Pointcut("execution(*  com.codeverse.code_verse_uni.dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    public void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toString();
        log.info("=====> in @Before: calling method: {}", method);

        Object[] args = joinPoint.getArgs();

        for(Object arg : args){
            log.info("=====> argument: {}", arg);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result){
        String method = joinPoint.getSignature().toString();
        log.info("=====> in @AfterReturning: calling method: {}", method);

        log.info("=====> result: {}", result);
    }
}
