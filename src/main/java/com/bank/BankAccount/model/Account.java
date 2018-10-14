package com.bank.BankAccount.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "ACCOUNT")
public class Account  implements Serializable{
	
	
	private static final long serialVersionUID = 9006979669750226556L;

	@Id
	@Column(name="ACCOUNT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long accountId;
	
	private String number;
	
	private double balance;
	
	@ManyToOne
	@JoinColumn (name="CLIENT_FK")
	private Client client;
	
	@OneToMany(targetEntity=Transaction.class, mappedBy="account", fetch=FetchType.LAZY)
	private List<Transaction> transactions;
	
	public Account() {
		transactions = new ArrayList<>();
	}
	

	public Account(Long accountId, String number, double balance, Client client, List<Transaction> transactions) {
		super();
		this.accountId = accountId;
		this.number = number;
		this.balance = balance;
		this.client = client;
		this.transactions = transactions;
	}


	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
	

}
