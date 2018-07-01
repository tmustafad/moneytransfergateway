/**
 * 
 */
package com.turkmen.transfers.money.service;

import java.math.BigDecimal;
import java.util.List;

import com.turkmen.transfers.money.exception.MoneyTransferGatewayException;
import com.turkmen.transfers.money.model.Account;

/**
 * @author TTTDEMIRCI
 *
 */
public interface AccountService {

	Account findById(Integer id);

	void createAccount(Account account);

	List<Account> getAllAccounts();

	void withdraw(Account account, Double amount) throws MoneyTransferGatewayException;

	void deposit(Account account, Double amount) throws MoneyTransferGatewayException;

	void deleteAccount(Account account);

	void transferTo(Integer fromAccountId, Integer toAccountId,Double balance) throws MoneyTransferGatewayException;

}
