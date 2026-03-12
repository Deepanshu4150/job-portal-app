package com.diji.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

//    return == type , class-name.method-name(args)

    @Before("execution(* com.diji.spring_boot_rest.service.JobService.getJob(..))")
    public void loggingMethodCalled(JoinPoint jp){
        logger.info("logging Method Called "+jp.getSignature().getName());
    }

    @After("execution(* com.diji.spring_boot_rest.service.JobService.getJob(..))")
    public void loggingMethodExecuted(JoinPoint jp){
        logger.info("Method executed "+jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.diji.spring_boot_rest.service.JobService.getJob(..))")
    public void loggingMethodCrashed(JoinPoint jp){
        logger.info("Method had some issues "+jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.diji.spring_boot_rest.service.JobService.getJob(..))")
    public void loggingMethodExecutedSuccess(JoinPoint jp){
        logger.info("Method executed successfully "+jp.getSignature().getName());
    }
}
