package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration  //开启自动化配置
@ComponentScan("com.example.demo") //类似于Spring的基础类扫描包，用来扫描实体，接口和控制器
@MapperScan("com.example.demo.dao") //mybatis的接口扫描包 包下面的所有接口在编译之后都会生成相应的实现类
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
