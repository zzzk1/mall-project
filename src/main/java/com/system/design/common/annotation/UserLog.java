package com.system.design.common.annotation;

import com.system.design.common.api.ModuleEnum;
import com.system.design.common.api.OperationEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UserLog {
    /**
     * 所属模块名
     */
    ModuleEnum module();

    /**
     * 操作标题
     */
    String title();

    /**
     * 操作类型
     */
    OperationEnum type();
}
