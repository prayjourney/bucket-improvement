package com.zgy.learn.aop.annotation.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RobotAspect {

    // 定义切点， com.zgy.all.aop.annotation.service包下的任何访问权限的类下的，有任何参数的任何方法
    // pointcut这个可以直接定义成为一个方法，也可以直接写到advice的条件之上，表示在这个切入的点，我去加载相应的通知
    @Pointcut("execution(* com.zgy.learn.aop.annotation.common.service.*.*(..))")
    public void pointCut1() {
    }

    @Before(value = "pointCut1()")
    public void beforeDoWork(JoinPoint point) {
        long time = System.currentTimeMillis();
        System.out.println("开始工作的时间是： " + time);
    }

    // 具体到关机的方法，来一个通知
    @After(value = "execution(public void com.zgy.learn.aop.annotation.common.service.RobotService.closeRobot())")
    public void afterDoneWork() {
        long time = System.currentTimeMillis();
        System.out.println("我的工作结束了： " + time);
    }
}
