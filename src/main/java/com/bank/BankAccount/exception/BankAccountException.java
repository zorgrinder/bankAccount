package com.bank.BankAccount.exception;

public class BankAccountException  extends RuntimeException{

	private static final long serialVersionUID = 1532938657273326105L;

	public BankAccountException(String msg) {
		super(msg);
	}
}
