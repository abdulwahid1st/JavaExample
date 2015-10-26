package com.enawe.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.enawe.component.annotations.LogTime;
import com.enawe.example.configs.ApplicationContextEnawe;
import com.enawe.example.models.Customer;
import com.enawe.example.services.AsyncService;
import com.enawe.example.services.BookService;
import com.enawe.example.services.CustomerService;
import com.enawe.example.services.SchedulerService;

public class Main {
	static final Logger logger = Logger.getLogger(Main.class);
	public static void main(String[] args) throws Exception {
		mainDUmmy();
	}
	@LogTime
	static void mainDUmmy() throws Exception{
		logger.debug("MAIN START-"+System.currentTimeMillis());
		ApplicationContext ac = new AnnotationConfigApplicationContext(
				ApplicationContextEnawe.class);

		Thread.sleep(1000);
		
		
//		BookService bookService = (BookService) ac.getBean("bookService");
//		bookService.makeBook();
		
		
//		AsyncService asyncService = (AsyncService) ac.getBean("asyncService");
//		asyncService.callMeLater();
		
		
		/*
		SchedulerService schedulerService = (SchedulerService) ac.getBean("schedulerService");
		schedulerService.runMeByCron();
		*/
		
		
		CustomerService customerService = (CustomerService) ac.getBean("customerService");
//		customerService.createCustomer("abdul", "waaaahid");
		customerService.saveByBatch(generateCustomersDummy());
		List<Customer> list = (List<Customer>) customerService.getAllCustomersUsingQuery();
		logger.debug(list);
		
		
		((ConfigurableApplicationContext)ac).close();
		logger.debug("MAIN DONE-"+System.currentTimeMillis());
	}
	static List<Customer> generateCustomersDummy(){
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(11,"Sunday","January"));
		customers.add(new Customer(12,"Monday","February"));
		customers.add(new Customer(13,"Tuesday","March"));
		customers.add(new Customer(14,"Wednesday","April"));
		customers.add(new Customer(15,"Thursday","May"));
		customers.add(new Customer(16,"Friday","June"));
		customers.add(new Customer(17,"Saturday","July"));
		customers.add(new Customer(18,"Sunday","August"));
		customers.add(new Customer(19,"Monday","September"));
		customers.add(new Customer(20,"Tuesday","October"));
		customers.add(new Customer(21,"Wednesday","November"));
		customers.add(new Customer(22,"Thursday","December"));
		customers.add(new Customer(23,"Friday","January"));
		customers.add(new Customer(24,"Saturday","February"));
		customers.add(new Customer(25,"Sunday","March"));
		customers.add(new Customer(26,"Monday","April"));
		customers.add(new Customer(27,"Tuesday","May"));
		customers.add(new Customer(28,"Wednesday","June"));
		customers.add(new Customer(29,"Thursday","July"));
		customers.add(new Customer(30,"Friday","August"));
		return customers;
	}
}


