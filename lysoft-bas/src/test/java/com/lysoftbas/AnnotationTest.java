package com.lysoftbas;

import com.lysoftbas.util.annotation.annoEntiy.Person;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * lysoft
 * Creat by zmy on 2021-05-12 14:43
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {LysoftBasApplication.class})
public class AnnotationTest {

    @Test
   public void init(){
        Person person = new Person();
        System.out.println(person.toString());
   }


    public void testSave() {
        System.out.println("save...");
    }








}
