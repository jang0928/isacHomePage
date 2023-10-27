package com.homeDemo.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

@Slf4j
@Component
@Aspect
public class LoggerAspect {
    @Around("execution(* com.homeDemo.demo..*Controller.*(..)) || execution(* com.homeDemo.demo..*Service.*(..)) || execution(* com.homeDemo.demo..*Repository.*(..))")
    public Object pringLog(ProceedingJoinPoint joinPoint) throws Throwable{
        String name = joinPoint.getSignature().getDeclaringTypeName();
        String type =
                StringUtils.contains(name, "Controller") ? "Controller ===> " :
                        StringUtils.contains(name, "Service") ? "Service ===> " :
                                StringUtils.contains(name, "Repository") ? "Mapper ===> " :
                                        "";

        log.debug(type + name + "." + joinPoint.getSignature().getName() + "()");
        return joinPoint.proceed();
    }
}
