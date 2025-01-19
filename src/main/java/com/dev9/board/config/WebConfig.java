package com.dev9.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final long MAX_AGE_SECS = 3600;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//				.allowedOrigins("http://localhost:3000")
//				.allowedOriginPatterns("**") // “*“같은 와일드카드를 사용
//				.allowedMethods("GET", "POST") // 허용할 HTTP method
//				.allowedMethods("**") // 허용할 HTTP method
//				.allowedHeaders("*")
//				.allowCredentials(true) // 쿠키 인증 요청 허용
//		        .maxAge(3600);

//		registry.addMapping("/**")
//        .allowedOrigins("*")
//        .allowedMethods("GET", "POST", "PUT", "DELETE")
//        .allowedHeaders("Authorization", "Content-Type")
//        .exposedHeaders("Custom-Header")
//        .allowCredentials(true)
//        .maxAge(3600);




        registry.addMapping("/**")
                // Origin이 http:localhost:3000에 대해
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(MAX_AGE_SECS);
	}
}
