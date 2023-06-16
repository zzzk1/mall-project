package com.example.mallproject.common.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author zzzk1
 */
@Slf4j
@Aspect // 第一步：声明这是一个切面类
public class ApiTimeLogAspect {

    // 第三步：定义切点表达式，明确要对那些方法起作用（比如，只对com.bravo.demo.controller包的方法计算接口耗时）
    @Pointcut("execution(* com.example.mallproject.controller.*.*(..))")
    public void controllerPointcut() {
    }

    // 第四步：1.通过引用切点表达式，明确这个增强的应用规则。 2.编写增强逻辑
    @Around("controllerPointcut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 记录接口执行前的时间戳
        long startTime = System.currentTimeMillis();
        // 实际执行目标方法，类似动态代理的invoke()执行目标方法
        Object result = proceedingJoinPoint.proceed();
        // 计算接口耗时
        log.info("------------ 耗时: {} ms ------------", System.currentTimeMillis() - startTime);
        // 只做增强不做改变，还是要把接口原本的结果返回
        return result;
    }
}
