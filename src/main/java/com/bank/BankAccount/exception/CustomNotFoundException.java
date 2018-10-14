package com.bank.BankAccount.exception;

public class CustomNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -8505696777517087021L;

		public CustomNotFoundException(String element, String table) {
			super("Element : "+element+" introuvable dans la table : "+table);
		}
	}

