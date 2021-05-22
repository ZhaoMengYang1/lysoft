package com.lysoftbas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.lysoftbas.dao")
@SpringBootApplication
public class LysoftBasApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(LysoftBasApplication.class, args);
        }catch (Exception e){
            System.err.println("spring启动失败原因:"+e.getMessage());
        }

    }

}
