package com.mydata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
//----------------------------------------------------------------------
// FeignClient를 사용하기 위해서는 @EnableFeignClients 어노테이션을 필수로 적용해야 합니다.
// 일반적으로 해당 어노테이션은 메인 애플리케이션 클래스에 설정하는데요. 
// 이 어노테이션은 하위 클래스를 탐색하면서 @FeignClient를 찾아 구현체를 생성하는 역할을 합니다.
//----------------------------------------------------------------------
@EnableFeignClients
public class MydataApplication {

	public static void main(String[] args) {
		SpringApplication.run(MydataApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
				//registry.addMapping("/**").allowedOrigins("http://front-server.com");
			}
		};
	}
}
