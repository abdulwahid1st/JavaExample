/**
 * 
 */
package com.enawe.example.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.enawe.component.configs.ApplicationContextComponent;

/**
 *
 * example-springmvc
 * com.enawe.example.config > ApplicationContext.java
 * @author N Abdul Wh
 *
 * Aug 15, 2015 - 3:43:20 PM
 */
@Configuration
@ComponentScan("com.enawe.example")
@Import({
	ApplicationContextComponent.class, 
	ApplicationContextAsync.class,
	ApplicationContextScheduler.class,
	ApplicationContextPersistence.class})
public class ApplicationContextEnawe{

}
