package com.kaizhang.aop.demo.aop;

import com.alibaba.fastjson.JSONObject;
import com.kaizhang.aop.demo.annotation.DoneTimeAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kaizhang
 */
@Aspect
@Component
public class DoneTimeAspect {

    @Around("@annotation(doneTime)")
    public Object around(ProceedingJoinPoint joinPoint, DoneTimeAnnotation doneTime) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println("方法开始前:" + request.getSession().getAttribute("session"));
        System.out.println("方法开始时间是:" + new Date());
        Object proceed = joinPoint.proceed();
        System.out.println("方法结束时间是:" + new Date());
        System.out.println("方法结束后:" + request.getSession().getAttribute("session"));
        request.getSession().setAttribute("session", "2333");
        //序列化时过滤掉request和response，排除参数序列化异常：It is illegal to call this method if the current request is not in asynchronous mode
        Object[] args = joinPoint.getArgs();
        Stream<?> stream = args.length == 0 ? Stream.empty() : Arrays.stream(args);
        List<Object> logArgs = stream
                .filter(arg -> (!(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse)))
                .collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(logArgs));
        System.out.println(JSONObject.toJSONString(joinPoint.getSignature()));
        System.out.println(JSONObject.toJSONString(joinPoint.getSignature().getName()));
        System.out.println(request.getRemoteAddr());
        return proceed;
    }
}
