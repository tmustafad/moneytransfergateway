/**
 * 
 */
package com.turkmen.transfers.money.service;

import java.util.List;

import com.turkmen.transfers.money.model.Customer;

/**
 * @author TTTDEMIRCI
 *
 */
public interface CustomerService {
	
	Customer findById(Integer id);

	void saveCustomer(Customer customer);

	List<Customer> getAllCustomers();
	
	void deleteCustomer(Customer customer);
}
