/**
 * 
 */
package com.turkmen.transfers.money.service.impl;

import java.util.List;

import com.turkmen.transfers.money.dao.CustomerDao;
import com.turkmen.transfers.money.dao.impl.CustomerDaoImpl;
import com.turkmen.transfers.money.model.Customer;
import com.turkmen.transfers.money.service.CustomerService;

/**
 * @author TTTDEMIRCI
 *
 */
public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerDao=new CustomerDaoImpl();

	public Customer findById(Integer id) {
		return customerDao.findById(id);
	}

	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
		
	}

	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
		
	}
	
	
}
