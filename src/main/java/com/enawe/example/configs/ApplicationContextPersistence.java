/**
 * 
 */
package com.enawe.example.configs;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.enawe.example.configs.datasources.LocalDataSourceConfiguration;

/**
 *
 * example-springmvc
 * com.enawe.example.configs > ApplicationContextPersistence.java
 * @author N Abdul Wh
 *
 * Sep 5, 2015 - 3:55:45 PM
 */
@Configuration
@EnableTransactionManagement
@Import({LocalDataSourceConfiguration.class})
public class ApplicationContextPersistence {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean(DataSource dataSource1) throws Exception {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource1);
		emf.setPackagesToScan("com.enawe.example.models");
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setGenerateDdl(true);
		
		emf.setJpaVendorAdapter(adapter);;
		return emf;
	}
    @Bean
    public PlatformTransactionManager transactionManager(javax.persistence.EntityManagerFactory entityManagerFactory) throws Exception {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
