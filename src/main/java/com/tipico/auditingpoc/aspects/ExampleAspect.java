package com.tipico.auditingpoc.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampleAspect {

    @Around("@annotation(com.tipico.auditingpoc.annotations.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println(joinPoint.getSignature().getName() + " executed in " + executionTime + "ms");
        return proceed;
    }

    @After("@annotation(com.tipico.auditingpoc.annotations.LogExecutionTime)")
    public void showMethodInfo(JoinPoint joinPoint) throws Throwable {
        System.out.printf("%s - %s%n", joinPoint.getSignature(), showArgs(joinPoint.getArgs()));
        // DO AUDITING STUFF HERE
    }

    private String showArgs(Object[] args) {
        String argsStr = new String();
        for (int i = 0; i < args.length; i++) {
            argsStr += args[i] + ",";
        }
        return argsStr;
    }
}


