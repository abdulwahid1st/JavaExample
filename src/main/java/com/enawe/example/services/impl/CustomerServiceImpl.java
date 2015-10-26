/**
 * 
 */
package com.enawe.example.services.impl;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enawe.example.models.Customer;
import com.enawe.example.services.CustomerService;

/**
 *
 * example-springmvc
 * com.enawe.example.services.impl > CustomerServiceImpl.java
 * @author N Abdul Wh
 *
 * Sep 5, 2015 - 4:30:47 PM
 */

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

	final static Logger logger = Logger.getLogger(BookServiceImpl.class);
//    private final static String CUSTOMER_CACHE = "customers";
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Customer updateCustomer(BigInteger id, String fn, String ln) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    @Transactional(readOnly = true)
	public Customer getCustomerById(BigInteger id) {
		return this.entityManager.find(Customer.class, id);
	}

	@Override
	public Customer createCustomer(String fn, String ln) {
		logger.debug("MASUK create Customer");
        Customer newCustomer = new Customer();
        newCustomer.setFirstName(fn);
        newCustomer.setLastName(ln);
        this.entityManager.persist(newCustomer);
        return newCustomer;
	}

	@Override
	public Collection<Customer> loadAllCustomers() {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaBuilderQuery = criteriaBuilder.createQuery(Customer.class);
        CriteriaQuery<Customer> customerCriteriaQuery = criteriaBuilderQuery.select(
                criteriaBuilderQuery.from(Customer.class));
        return this.entityManager.createQuery(customerCriteriaQuery).getResultList();
	}
	
	@Override
	public Collection<Customer> getAllCustomersUsingQuery() {
		Query query = this.entityManager.createNamedQuery("queryCustomer.getAllCustomer");
		List<Customer> list = query.getResultList();
		logger.debug("LOAD all customer using named query");
		return list;
	}

	@Override
	public void saveByBatch(List<Customer> customers) {
		for (Customer customer : customers) {
			this.entityManager.persist(customer);
		}
	}
	

}
