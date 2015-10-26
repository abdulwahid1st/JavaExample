package com.enawe.example.dao.impl;

import org.springframework.stereotype.Repository;

import com.enawe.component.annotations.LogTime;
import com.enawe.example.dao.BookDao;

@Repository("bookDao3")
public class BookDaoImpl implements BookDao {

	@Override
	@LogTime
	public String printBook() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Welcome to my laptop DAO DAO";
	}

}
