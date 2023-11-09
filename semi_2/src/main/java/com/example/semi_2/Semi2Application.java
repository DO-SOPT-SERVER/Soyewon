package com.example.semi_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
// @EnableJpaAuditing // 추상 클래스를 사용하겠다고 명시해주는 것 -> JpaAuditingConfig.java에서 해줌
public class Semi2Application {

	public static void main(String[] args) {
		SpringApplication.run(Semi2Application.class, args);
	}

}
