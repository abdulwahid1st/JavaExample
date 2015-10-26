/**
 * 
 */
package com.enawe.example.configs;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *
 * example-springmvc
 * com.enawe.example.configs > ApplicationContextAsync.java
 * @author N Abdul Wh
 *
 * Aug 16, 2015 - 2:17:21 PM
 */
@Configuration
@EnableAsync
public class ApplicationContextAsync implements AsyncConfigurer{
	@Override
	@Bean
	public Executor getAsyncExecutor() {
		return new SimpleAsyncTaskExecutor();
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		// TODO Auto-generated method stub
		return null;
	}
}
