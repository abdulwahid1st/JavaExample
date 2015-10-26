package com.enawe.example.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.enawe.component.annotations.LogTime;
import com.enawe.example.dao.BookDao;
import com.enawe.example.services.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService{

	final static Logger logger = Logger.getLogger(BookServiceImpl.class);
	@Autowired
	@Qualifier("bookDao3")
	private BookDao bookDao;
	
	/* (non-Javadoc)
	 * @see com.enawe.example.service.BookService#makeBook()
	 */
	@Override
	@LogTime
	public void makeBook() throws Exception {
		logger.debug("Youre called using log:"+bookDao.printBook());
		try {
			makeAnotherBook();
		} catch (Exception e) {
			logger.error(e,e);
			throw e;
		}
	}

	public void makeAnotherBook() throws Exception{
		Thread.sleep(1000);
		logger.debug("MAKE ANOTHER BOOK:");
//		throw new Exception("LPO");
	}

}
