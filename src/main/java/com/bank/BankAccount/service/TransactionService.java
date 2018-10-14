package com.bank.BankAccount.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.BankAccount.repository.TransactionRepository;

@Service
public class TransactionService {

	
	@Autowired
    private TransactionRepository transactionRepository;
	
}
