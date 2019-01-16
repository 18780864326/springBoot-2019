package com.example.demo.config;



import javax.sql.DataSource;

import org.baseRepository.first.BaseRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.alibaba.druid.pool.DruidDataSource;

/**
 * 
 * <p>相当于 spring 的 applicationConfig配置文件 </p>
 * <p>定义数据源 : </p>
 * <p>定义Jpa自定义拓展类工厂 : </p>
 * <p>Copyright (c) 2019 LionCredo.All Rights Reserved. C3005890</p>
 */
//@ComponentScan
//@Configuration
//@EnableJpaRepositories(basePackages = {"com.example.demo.repository"},repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)//指定自己的工厂类
public class ApplicationConfig {
	 @Autowired
	    private Environment env;

	    @Bean
	    public DataSource getDataSource() {
	        DruidDataSource dataSource = new DruidDataSource();
	        dataSource.setUrl(env.getProperty("spring.datasource.url"));
	        dataSource.setUsername(env.getProperty("spring.datasource.username"));
	        dataSource.setPassword(env.getProperty("spring.datasource.password"));
	        return dataSource;
	    }   
}
