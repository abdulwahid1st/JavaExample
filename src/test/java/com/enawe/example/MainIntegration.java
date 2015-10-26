/**
 * 
 */
package com.enawe.example;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.enawe.component.configs.ApplicationContextFileBatch;

/**
 *
 * example-springmvc
 * com.enawe.example > MainIntegration.java
 * @author N Abdul Wh
 *
 * Oct 4, 2015 - 9:35:01 AM
 */
public class MainIntegration {
	static final Logger logger = Logger.getLogger(MainIntegration.class);
	public static void main(String[] args) {
		logger.debug("@@@@@@@@@@@@@@@@@@ START");
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				ApplicationContextFileBatch.class);
	}
}
