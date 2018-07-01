/**
 * 
 */
package com.turkmen.transfers.money.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author TTTDEMIRCI
 *
 */



@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@Table(name = "CUSTOMER")
public class Customer {

	@JsonProperty(required=true)
	private String name;
	
	@JsonProperty(required=true)
	private String surname;
	
	
	private Integer id;

	public Customer() {

	}

	public Customer(String name, String surname, List<Account> accounts) {
		super();
		this.name = name;
		this.surname = surname;
		this.accounts = accounts;
	}

	
	private List<Account> accounts = new ArrayList<Account>();

	public void addAccount(Account account) {
		accounts.add(account);
		account.setCustomer(this);
	}

	public void removeAccount(Account account) {
		accounts.remove(account);
		account.setCustomer(null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column(name = "CUSTOMER_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
