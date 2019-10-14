package com.zgy.learn.aop.annotation.simpletest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: renjiaxin
 * @Despcription: 我们不用去修改业务代码， 而只是进行切面的声明，然后就可以操作了，实际很重要的，切面，切点，通知，表达式这几个
 * @Date: Created in 2019/10/14 2:14
 * @Modified by:
 */
@Aspect
@Component
public class LogAspect {

    /**
     * 定义一个方法, 用于声明切入点表达式. 一般地, 该方法中再不需要添入其他的代码.
     * 使用 @Pointcut 来声明切入点表达式.
     * 后面的其他通知直接使用方法名来引用当前的切入点表达式.
     */
    @Pointcut("execution(* com.zgy.learn.aop.annotation.simpletest.*.*(..))")
    public void declareJointPointExpression(){}

    /**
     * 在 com.zgy.learn.aop.annotation.XiaoMing每一个方法开始之前执行一段代码
     */
    // 切点的位置很重要
    @Before("execution(* com.zgy.learn.aop.annotation..simpletest.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object [] args = joinPoint.getArgs();

        System.out.println("The method [" + methodName + "] begins with " + Arrays.asList(args));
    }

    /**
     * 在方法执行之后执行的代码. 无论该方法是否出现异常
     */
    @After("declareJointPointExpression()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method [" + methodName + "] ends");
    }
}
