/**
 * 
 */
package com.enawe.component.configs;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 * example-springmvc
 * com.enawe.component > ComponentConfiguration.java
 * @author N Abdul Wh
 *
 * Aug 15, 2015 - 3:31:36 PM
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.enawe.component")
public class ApplicationContextComponent {
}
