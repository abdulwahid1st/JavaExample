/**
 * 
 */
package com.enawe.example.services;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

import com.enawe.example.models.Customer;

/**
 *
 * example-springmvc
 * com.enawe.example.services > CustomerService.java
 * @author N Abdul Wh
 *
 * Sep 5, 2015 - 4:29:57 PM
 */
public interface CustomerService {
    Customer updateCustomer( BigInteger id, String fn, String ln);

    Customer getCustomerById(BigInteger id);

    Customer createCustomer(String fn, String ln);

    Collection<Customer> loadAllCustomers();
    
    Collection<Customer> getAllCustomersUsingQuery();
    
    void saveByBatch(List<Customer> customers);
}
