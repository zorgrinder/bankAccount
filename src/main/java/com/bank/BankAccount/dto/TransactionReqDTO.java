package com.bank.BankAccount.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.bank.BankAccount.model.TransactionType;


public class TransactionReqDTO {
	
	
	@NotNull(message = "TransactionType is a required field")
	private TransactionType transactionType;
	
	
	@NotNull(message = "Amount is a required field")
	@DecimalMin("0.1")
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
