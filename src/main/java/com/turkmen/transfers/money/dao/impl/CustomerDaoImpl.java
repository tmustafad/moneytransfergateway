/**
 * 
 */
package com.turkmen.transfers.money.dao.impl;

import java.util.List;

import com.turkmen.transfers.money.dao.AbstractDao;
import com.turkmen.transfers.money.dao.CustomerDao;
import com.turkmen.transfers.money.model.Customer;

/**
 * @author TTTDEMIRCI
 *
 */
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {

	public Customer findById(Integer id) {

		return getByKey(id);
	}

	public void saveCustomer(Customer customer) {
		persist(customer);

	}

	public List<Customer> getAllCustomers() {
		return getAllEntities();
	}



	public void deleteCustomer(Customer customer) {
		 delete(customer);
		
	}

	
}
