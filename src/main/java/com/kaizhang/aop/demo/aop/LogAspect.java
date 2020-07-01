/*
package com.kaizhang.aop.demo.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(public * com.kaizhang.aop.demo.controller..*.*(..))")
    public void LogAspect() {
    }

    @Before("LogAspect()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        System.out.println("doBefore" + JSONObject.toJSONString(joinPoint.getArgs()));
    }

    @After("LogAspect()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("doAfter");
    }

    @AfterReturning("LogAspect()")
    public void doAfterReturning(JoinPoint joinPoint) {
        System.out.println("doAfterReturning");
    }

    @AfterThrowing("LogAspect()")
    public void deAfterThrowing(JoinPoint joinPoint) {
        System.out.println("deAfterThrowing");
    }

    @Around("LogAspect()")
    public Object deAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("deAround");
        return joinPoint.proceed();
    }
}
*/
