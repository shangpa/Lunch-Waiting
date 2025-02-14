package org.example.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); //내 서버가 응답을 할 때 json을 자바스크립트에서 처리할 수 있게 할지를 결정한느 것
        config.addAllowedOrigin("*"); // 모든 ip에 응답을 허용하겠다
        config.addAllowedHeader("*"); // 모든 header에 응답을 허용하겠다
        config.addAllowedMethod("*"); // 모든 post, get, put, delete, patch 요청을 허용하겠다 => 필터에도 등록을 해줘야 의미가 있음   (SecurityConfig 클래스 파일에 설정해야함)

        source.registerCorsConfiguration("/api/**", config); //해당 메서드 안의 파라미터 주소 값으로 들어오는 모든 값들은 config를 설정을 따르라고 설정하는 메서드
        return new CorsFilter(source);
    }

}