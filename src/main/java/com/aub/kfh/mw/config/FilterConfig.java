package com.aub.kfh.mw.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aub.kfh.mw.filter.JwtFilter;

@Configuration
public class FilterConfig {
	
	@Bean
	FilterRegistrationBean<JwtFilter> jwtFilter() {
		
		FilterRegistrationBean<JwtFilter> filter = new FilterRegistrationBean<JwtFilter>();
		filter.setFilter(new JwtFilter());
		filter.addUrlPatterns("/api/v1/blog/restricted");
		return filter;
		
	}
	//adding comment
}
