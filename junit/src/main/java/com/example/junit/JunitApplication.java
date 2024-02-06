package com.example.junit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 이 어노테이션이 있는 부분부터 bean 읽기, 쓰기 자동으로 설정
public class JunitApplication {

	public static void main(String[] args) {
		SpringApplication.run(JunitApplication.class, args);
		// 내장 WAS실행
	}

}
