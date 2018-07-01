/**
 * 
 */
package com.turkmen.transfers.money.dao;

import java.util.List;

import com.turkmen.transfers.money.model.Account;

/**
 * @author TTTDEMIRCI
 *
 */
public interface AccountDao {

	Account findById(Integer id);

	void createAccount(Account account);

	List<Account> getAllAccounts();
	
	void deleteAccount(Account account);
	
	void updateAccount(Account account);
}
