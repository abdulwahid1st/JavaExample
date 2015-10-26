/**
 * 
 */
package com.enawe.example.services.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.enawe.component.annotations.LogTime;
import com.enawe.example.dao.BookDao;
import com.enawe.example.services.SchedulerService;

/**
 *
 * example-springmvc
 * com.enawe.example.services.impl > SchedulerServiceImpl.java
 * @author N Abdul Wh
 *
 * Aug 16, 2015 - 2:24:48 PM
 */
@Service("schedulerService")
public class SchedulerServiceImpl implements SchedulerService{

	static final Logger logger = Logger.getLogger(SchedulerServiceImpl.class);
	static final String CRON = "0,5,10,15,20,25,30,35,40,45,50,55 * * * * ?";
	@Autowired
	private BookDao bookDao;
	
	@Override
//	@Scheduled(cron=CRON)
	public void runMeByCron() {
		long x = System.currentTimeMillis();
		logger.debug("SCHEDULER OKE 1-"+x+"-"+new Date());
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			logger.error(e,e);
		}
		bookDao.printBook();
		logger.debug("SCHEDULER OKE 2-"+x+"-"+new Date());
	}
}
