/**
 * 
 */
package com.enawe.component.configs;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.integration.launch.JobLaunchingMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 *
 * example-springmvc
 * com.enawe.component.configs > ApplicationContextFileBatch.java
 * @author N Abdul Wh
 *
 * Oct 4, 2015 - 9:37:37 AM
 */
@Configuration
@ImportResource("classpath:/integration-context.xml")
@ComponentScan("com.enawe.component.modules")
public class ApplicationContextFileBatch {
//	@Bean
//	public JobLaunchingMessageHandler jobMessageHandler(JobLauncher jobLauncher){
//		return new JobLaunchingMessageHandler(jobLauncher);
//	}
}
