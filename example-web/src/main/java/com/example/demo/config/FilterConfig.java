package com.example.demo.config;

import com.example.demo.system.filter.DefaultPageFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.system.filter.LoginFilter;
import org.springframework.core.annotation.Order;

@Configuration
public class FilterConfig {

	@Bean
	public DefaultPageFilter defaultPageFilter() {
		return new DefaultPageFilter();
	}

	@Bean
	public LoginFilter loginFilter() {
		return new LoginFilter();
	}

	@Bean
	@Order(Integer.MAX_VALUE)
	public FilterRegistrationBean defaultPageFilterRegistration() {
		//新建过滤器注册类
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter( defaultPageFilter());
		registration.addUrlPatterns("/*");
		return registration;
	}

	 @Bean
	 @Order(Integer.MAX_VALUE-1)
	    public FilterRegistrationBean loginFilterRegistration() {
	        //新建过滤器注册类
	        FilterRegistrationBean registration = new FilterRegistrationBean();
	        registration.setFilter( loginFilter());
	        registration.addUrlPatterns("/*");
	        return registration;
	    }

}
