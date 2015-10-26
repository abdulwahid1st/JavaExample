/**
 * 
 */
package com.enawe.example.configs;

import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

/**
 *
 * example-springmvc
 * com.enawe.example.configs > ApplicationContextScheduler.java
 * @author N Abdul Wh
 *
 * Aug 16, 2015 - 2:19:40 PM
 */

@Configuration
@EnableScheduling
public class ApplicationContextScheduler{

	@Bean
	public TaskScheduler concurrentTaskScheduler(){
		ConcurrentTaskScheduler concurrentTaskScheduler = new ConcurrentTaskScheduler();
		concurrentTaskScheduler.setScheduledExecutor(Executors.newScheduledThreadPool(10));
		return concurrentTaskScheduler;
	}
}
