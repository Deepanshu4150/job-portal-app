package com.diji.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMoniterAspect {

    private static final Logger log = LoggerFactory.getLogger(PerformanceMoniterAspect.class);

    @Around("execution(* com.diji.spring_boot_rest.service.JobService.*(..))")
    public Object moniterTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();

        log.info("Time taken by : "+ pjp.getSignature().getName()+" : " + (end - start));

        return result;
    }
}
