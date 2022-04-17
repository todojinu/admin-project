package com.example.adminproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration  // @Configuration 으로 지정해 JPA 관련된 설정을 본 클래스에서 작성할 수 있다
@EnableJpaAuditing  // JpaAuditing 활성화
public class JpaConfig {
}
