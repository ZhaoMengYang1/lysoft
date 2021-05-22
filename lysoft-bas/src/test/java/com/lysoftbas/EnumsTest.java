package com.lysoftbas;

import com.lysoftbas.util.enums.Level;

import org.junit.jupiter.api.Test;

/**
 * lysoft
 * Creat by zmy on 2021-05-12 11:40
 */
public class EnumsTest {

    @Test
    public void enumsTest(){
        System.out.println("ENUMS:"+Level.valueOf("LOW"));
    }
}
