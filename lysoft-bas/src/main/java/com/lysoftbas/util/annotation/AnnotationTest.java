package com.lysoftbas.util.annotation;

import com.lysoftbas.util.annotation.annoEntiy.Person;

/**
 * lysoft
 * Creat by zmy on 2021-05-12 16:58
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Person person = new Person();
        Class clazz = person.getClass();
        //判断person对象上是否有Info注解
        if (clazz.isAnnotationPresent(Info.class)){
            System.out.println("Persno类上配置了Info注解！");
            //获取该对象上Info类型的注解
            Info infoAnno = (Info) clazz.getAnnotation(Info.class);
            System.out.println("Person.name:"+infoAnno.value()+",Person.isDelete:"+infoAnno.isDelete());
        }else {
            System.out.println("Person类上没有注解！");
        }
    }
}
