/**
 * 
 */
package com.enawe.example.configs.datasources;

import java.sql.Driver;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


/**
 *
 * example-springmvc
 * com.enawe.example.configs.datasources > LocalDataSourceConfiguration.java
 * @author N Abdul Wh
 *
 * Sep 5, 2015 - 4:05:53 PM
 */
@PropertySource("classpath:/services.properties")
@Configuration
@Profile("default")
public class LocalDataSourceConfiguration {
    @Bean
    public DataSource dataSource1(Environment environment) throws Exception {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setPassword(environment.getProperty("dataSource.password"));
        dataSource.setUrl(environment.getProperty("dataSource.url"));
        dataSource.setUsername(environment.getProperty("dataSource.user"));
        dataSource.setDriverClassName(environment.getPropertyAsClass("dataSource.driverClass", Driver.class).getName());
        return dataSource;
    }
    @Bean
    public DataSource dataSource2(Environment environment) throws Exception {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setPassword(environment.getProperty("dataSource.password1"));
        dataSource.setUrl(environment.getProperty("dataSource.url1"));
        dataSource.setUsername(environment.getProperty("dataSource.user1"));
        dataSource.setDriverClassName(environment.getPropertyAsClass("dataSource.driverClass", Driver.class).getName());
        return dataSource;
    }
}
