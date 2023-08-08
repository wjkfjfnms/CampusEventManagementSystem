package com.six.campuseventmanagementsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.six.campuseventmanagementsystem.mapper")
//@ComponentScan("com.six.campuseventmanagementsystem.service")
public class CampusEventManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusEventManagementSystemApplication.class, args);
    }

}
