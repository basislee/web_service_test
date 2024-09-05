package com.spring_boot_mybatis.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@ComponentScan(basePackages = {"com.spring_boot_mybatis.project"})
@MapperScan(basePackages = {"com.spring_boot_mybatis.project"})
//DB 연결정보 : 프로퍼티 사용
//로컬 경로 / 서버 경로
@PropertySources({
@PropertySource(value={"file:c:/springWorkspace/configure.properties",
		"file:/usr/local/project/properties/configure.properties", },
			ignoreResourceNotFound=true)
}) 
public class SpringBootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisApplication.class, args);
	}

}
