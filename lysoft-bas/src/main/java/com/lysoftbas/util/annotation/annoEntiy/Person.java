package com.lysoftbas.util.annotation.annoEntiy;

import com.lysoftbas.util.annotation.Info;

/**
 * lysoft
 * Creat by zmy on 2021-05-12 16:55
 */
@Info(isDelete = true)
public class Person {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 是否有效
     */
    private boolean isDelete;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isDelete=" + isDelete +
                '}';
    }
}
