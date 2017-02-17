package com.freedom.aop.annotations;

import java.lang.annotation.*;

/**
 * Created by Huangxiaoxu on 2016/6/5.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogImp {
    String value()  default "";
}
