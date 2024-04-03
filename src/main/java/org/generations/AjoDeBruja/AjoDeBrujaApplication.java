package org.generations.AjoDeBruja;

import org.generations.AjoDeBruja.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AjoDeBrujaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AjoDeBrujaApplication.class, args);
	}// main

	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter() {
		FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/productos/*");
		registrationBean.addUrlPatterns("/api/users/*");
		return registrationBean;
	}// JwtFilter
}// class AjoDeBrujaApplication
