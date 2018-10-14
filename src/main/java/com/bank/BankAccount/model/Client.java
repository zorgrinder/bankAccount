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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CLIENT")
public class Client  implements Serializable{
	
	
	private static final long serialVersionUID = -2844182272978558638L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CLIENT_ID")
	private Long clientId;
	
	private String name;
	
	private String lastname;
	
	@OneToMany(targetEntity=Account.class, mappedBy="client", fetch=FetchType.LAZY)
	private List<Account> accounts;
	

	public Client() {
		accounts = new ArrayList<>();
	}
	
	

	public Client(Long clientId, String name, String lastname) {
		super();
		this.clientId = clientId;
		this.name = name;
		this.lastname = lastname;
	}



	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	

}
