/**
 * 
 */
package com.turkmen.transfers.money.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.spi.ResponseExecutorsProvider;

import com.sun.research.ws.wadl.HTTPMethods;
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

@Path("/transferGateway")
public class MainController {

	AccountService accountService = new AccountServiceImpl();
	CustomerService customerService = new CustomerServiceImpl();

	@GET
	@Path("/getAllCustomers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getAllCustomers() {

		return customerService.getAllCustomers();
	}

	@GET
	@Path("/getAllAccounts")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> getAllAccounts() {

		return accountService.getAllAccounts();
	}

	@POST
	@Path("/createAccount")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAccount(Account account) {
		this.accountService.createAccount(account);
		return Response.status(200).type("application/json").entity("success").build();
	}

	@POST
	@Path("/createCustomer")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCustomer(Customer customer) {
		this.customerService.saveCustomer(customer);
		return Response.status(201).type("application/json").entity("success").build();
	}
	
	@DELETE
	@Path("/deleteCustomer")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCustomer(Customer customer) {
		this.customerService.deleteCustomer(customerService.findById(customer.getId()));
		return Response.status(200).type("application/json").entity("success").build();
	}
	
	
	@DELETE
	@Path("/deleteAccount")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteAccount(Account account) {
		this.accountService.deleteAccount(accountService.findById(account.getId()));;
		return Response.status(200).type("application/json").entity("success").build();
	}

}
