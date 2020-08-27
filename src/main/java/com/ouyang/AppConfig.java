package com.ouyang;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ouyang.adapter.PayAdapterFactory;

@PropertySource(value = {"classpath:application.properties"})
@ComponentScan("com.ouyang")
@Configuration
public class AppConfig {
	
	
	public static void main(String[] args) {
		ApplicationContext app =  new AnnotationConfigApplicationContext(AppConfig.class);
		PayAdapterFactory bean = app.getBean(PayAdapterFactory.class);
		System.out.println(bean);
	}
	 
}
