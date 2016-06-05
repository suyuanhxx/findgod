package com.freedom.aop.imp;

import java.lang.annotation.*;

/**
 * Created by Huangxiaoxu on 2016/6/5.
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogImp {
    String description()  default "";
}
