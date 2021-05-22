package com.lysoftbas.util.annotation;

import java.lang.annotation.*;

/**
 * lysoft
 * Creat by zmy on 2021-05-12 14:33
 * @Target指定该注解使用的地方
 * @Doucumented可有可无
 *@Retention(RetentionPolicy.RUNTIME) 的意思就是指定该 Annotation 的策略是 RetentionPolicy.RUNTIME。这就意味着，
 * 编译器会将该 Annotation 信息保留在 .class 文件中，并且能被虚拟机读取。
 *
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation1 {
    public String name() default "fieldName";

}
