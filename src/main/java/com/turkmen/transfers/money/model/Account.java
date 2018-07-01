/**
 * 
 */
package com.turkmen.transfers.money.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author TTTDEMIRCI
 *
 */
@Entity
@Table(name = "ACCOUNT")
public class Account {

	
	private Integer id;

	
	private Customer customer;
	
	@JsonProperty(required=true)
	private Double balance;
	
	@JsonProperty(required=true)
	private String type;

	public Account() {

	}
	
	
	

	public Account(Customer customer, Double balance, String type) {
		super();
		this.customer = customer;
		this.balance = balance;
		this.type = type;
	}




	@Column(name = "ACCOUNT_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CUSTOMER_ID")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
