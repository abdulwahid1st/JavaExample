/**
 * 
 */
package com.enawe.example.services.impl;
 
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.enawe.component.annotations.LogTime;
import com.enawe.example.dao.BookDao;
import com.enawe.example.services.AsyncService;

/**
 *
 * example-springmvc
 * com.enawe.example.services.impl > AsyncServiceImpl.java
 * @author N Abdul Wh
 *
 * Aug 16, 2015 - 1:44:37 PM
 */
@Service("asyncService")
public class AsyncServiceImpl implements AsyncService{

	static final Logger logger = Logger.getLogger(AsyncServiceImpl.class);
	
	//required=false for testing, it should be error, because the correct bean qualifier is bookDao3
	@Autowired(required=false)
	@Qualifier("bookDao")
	private BookDao bookDao;
	
	@Override
	@LogTime
	@Async
	public void callMeLater() {
		logger.debug("OKE 1-"+System.currentTimeMillis());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			logger.error(e,e);
		}
//		bookDao.printBook();
		callMeLater2();
		logger.debug("OKE 2-"+System.currentTimeMillis());
	}
	public void callMeLater2() {
		logger.debug("OKE 3-"+System.currentTimeMillis());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			logger.error(e,e);
		}
		bookDao.printBook();
		logger.debug("OKE 4-"+System.currentTimeMillis());
	}
}
