/**
 * 
 */
package com.turkmen.transfers.money.dao;

import java.util.List;

import com.turkmen.transfers.money.model.Customer;

/**
 * @author TTTDEMIRCI
 *
 */
public interface CustomerDao {

	
	Customer findById(Integer id);

	void saveCustomer(Customer customer);

	List<Customer> getAllCustomers();
	
	
	void deleteCustomer(Customer customer);
}
