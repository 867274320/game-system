package org.evolution;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
@MapperScan("org.evolution.modules")
public class GameSystemApplication {
    //jvisualvm
    public static void main(String[] args) {
        SpringApplication.run(GameSystemApplication.class,args);
    }
}
