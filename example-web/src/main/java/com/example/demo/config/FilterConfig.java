package com.example.demo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.system.filter.LoginFilter;

@Configuration
public class FilterConfig {
	 @Bean
	    public FilterRegistrationBean someFilterRegistration1() {
	        //新建过滤器注册类
	        FilterRegistrationBean registration = new FilterRegistrationBean();
	        // 添加我们写好的过滤器
	        registration.setFilter( new LoginFilter());
	        // 设置过滤器的URL模式
	        registration.addUrlPatterns("/*");
	        return registration;
	    }

}
