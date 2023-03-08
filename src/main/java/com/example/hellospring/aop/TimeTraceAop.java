package com.example.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Component 하거나 직접 bean 등록해야함
@Component
@Aspect
public class TimeTraceAop {

    @Around("execution(* com.example.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{

        long start = System.currentTimeMillis();
        System.out.println("START = " + joinPoint.toLongString());
        try{
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            System.out.println("END: " +joinPoint.toString()+" "+timeMs + "ms");
        }
    }
}
