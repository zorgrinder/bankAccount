package com.bank.BankAccount.dto;

import java.util.Date;


import com.bank.BankAccount.model.TransactionType;


public class TransactionResDTO {
	
	
	private TransactionType transactionType;
	
	private double amount;
	
	private Date date;

	public TransactionType getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	

}
