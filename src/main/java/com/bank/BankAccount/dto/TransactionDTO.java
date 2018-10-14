package com.bank.BankAccount.dto;

import javax.validation.constraints.NotNull;

import com.bank.BankAccount.model.TransactionType;


public class TransactionDTO {
	
	
	@NotNull(message = "TransactionType is a required field")
	private TransactionType transactionType;
	
	
	@NotNull(message = "Amount is a required field")
	private double amount;


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
	
	
	
	

}
