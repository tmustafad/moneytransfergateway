/**
 * 
 */
package com.turkmen.transfers.money.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.turkmen.transfers.money.dao.AccountDao;
import com.turkmen.transfers.money.dao.impl.AccountDaoImpl;
import com.turkmen.transfers.money.exception.MoneyTransferGatewayException;
import com.turkmen.transfers.money.model.Account;
import com.turkmen.transfers.money.service.AccountService;

/**
 * @author TTTDEMIRCI
 *
 */
public class AccountServiceImpl implements AccountService {

	AccountDao accountDao = new AccountDaoImpl();

	public Account findById(Integer id) {
		return accountDao.findById(id);
	}

	public void createAccount(Account account) {
		accountDao.createAccount(account);

	}

	public List<Account> getAllAccounts() {
		return accountDao.getAllAccounts();
	}

	public void withdraw(Account account, Double amount) throws MoneyTransferGatewayException {
		if (account.getBalance() > amount)
			account.setBalance(account.getBalance() - amount);

		else
			throw new MoneyTransferGatewayException("The account does not have sufficient balance");

	}

	public void deposit(Account account, Double amount) throws MoneyTransferGatewayException {

		account.setBalance(account.getBalance() + amount);
	}

	public void transferTo(Integer fromAccountId, Integer toAccountId, Double balance)
			throws MoneyTransferGatewayException {
		Account from = accountDao.findById(fromAccountId);
		Account to = accountDao.findById(toAccountId);

		if (from == null || to == null)
			throw new MoneyTransferGatewayException("One of the accounts does not exist");

		if (!from.getType().equals(to.getType()))
			throw new MoneyTransferGatewayException(
					"The account types must be the same in order to have a successful transfer between accounts");
		
		if(from.getBalance()>balance) {
			withdraw(from, balance);
			deposit(to, balance);
		}
		else
			throw new MoneyTransferGatewayException("The account does not have sufficient balance to transfer money");
			

	}

	public void deleteAccount(Account account) {
		accountDao.deleteAccount(account);

	}

}
