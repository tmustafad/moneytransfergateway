/**
 * 
 */
package com.turkmen.transfers.money.util;

import com.turkmen.transfers.money.model.Account;
import com.turkmen.transfers.money.model.Customer;
import com.turkmen.transfers.money.service.AccountService;
import com.turkmen.transfers.money.service.CustomerService;
import com.turkmen.transfers.money.service.impl.AccountServiceImpl;
import com.turkmen.transfers.money.service.impl.CustomerServiceImpl;

/**
 * @author TTTDEMIRCI
 *
 */
public class MoneyTransferGatewayUtils {
	
	public static final int PORT = 7777;
	public static final String HOST = "http://localhost/";
	public static final Double  TRANFER_TRANSACTION_FEE=Double.valueOf(10); 
	
	
	public static void loadSampleData() {
		AccountService accountService = new AccountServiceImpl();
		CustomerService customerService = new CustomerServiceImpl();

		Customer customer = new Customer();
		customer.setName("OSMAN");
		customer.setSurname("AKSOY");

		Account account = new Account();
		account.setBalance(Double.valueOf(2000));
		account.setType("DEPOSIT");

		Account account1 = new Account();
		account1.setBalance(Double.valueOf(500000));
		account1.setType("CHECKING");
		
		customer.addAccount(account);
		customer.addAccount(account1);
		customerService.saveCustomer(customer);


		Account accountLast=new Account();
		accountLast.setBalance(Double.valueOf(444));
		accountLast.setType("DEPOSIT");
		Customer customer2=customerService.findById(1);
		
		accountLast.setCustomer(customer2);
		accountService.createAccount(accountLast);
		
	
	}
}
