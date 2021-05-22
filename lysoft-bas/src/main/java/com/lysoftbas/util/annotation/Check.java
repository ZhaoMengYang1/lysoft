package com.lysoftbas.util.annotation;

import java.lang.annotation.*;

/**
 * lysoft
 * Creat by zmy on 2021-05-12 15:05
 */
@Documented
@Target(ElementType.FIELD )
@Retention(RetentionPolicy.RUNTIME)
public @interface Check {
    String value();
}
