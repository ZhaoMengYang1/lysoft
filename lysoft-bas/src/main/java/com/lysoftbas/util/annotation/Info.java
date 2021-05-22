package com.lysoftbas.util.annotation;

import java.lang.annotation.*;

/**
 * lysoft
 * Creat by zmy on 2021-05-12 16:54
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Info {
    String value() default "tracy";
    boolean isDelete();
    String name() default "InfoAnnotation";
}
