package com.ssj.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApp {
    //内置Tomcat直接main方法启动
    //http://localhost:8888/login.html
    public static void main(String[] args) {
        SpringApplication.run(StartApp.class,args);

    }

}
