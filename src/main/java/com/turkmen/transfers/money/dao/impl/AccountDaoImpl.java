/**
 * 
 */
package com.turkmen.transfers.money.dao.impl;

import java.util.List;

import com.turkmen.transfers.money.dao.AbstractDao;
import com.turkmen.transfers.money.dao.AccountDao;
import com.turkmen.transfers.money.model.Account;

/**
 * @author TTTDEMIRCI
 *
 */
public class AccountDaoImpl extends AbstractDao<Integer, Account> implements AccountDao {

	public Account findById(Integer id) {
		return getByKey(id);
	}

	public void createAccount(Account account) {
		persist(account);

	}

	public List<Account> getAllAccounts() {
		return getAllEntities();
	}

	public void deleteAccount(Account account) {
		delete(account);
		
	}

	public void updateAccount(Account account) {
		merge(account);
		
	}

	
	
}
