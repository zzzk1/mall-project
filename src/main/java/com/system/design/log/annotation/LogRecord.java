package com.system.design.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zzzk1
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogRecord {
    String context() ;
    String operator() default "";
    String bizNo();
    String operatorType();
}
