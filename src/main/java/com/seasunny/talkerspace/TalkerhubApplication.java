package com.seasunny.talkerspace;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.seasunny.talkerspace.mapper")
public class TalkerhubApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalkerhubApplication.class, args);
		
	}

}
