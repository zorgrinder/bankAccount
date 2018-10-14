package com.bank.BankAccount.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bank.BankAccount.exception.BankAccountException;
import com.bank.BankAccount.exception.CustomNotFoundException;
import com.bank.BankAccount.model.Account;
import com.bank.BankAccount.model.Transaction;
import com.bank.BankAccount.model.TransactionType;
import com.bank.BankAccount.repository.AccountRepository;
import com.bank.BankAccount.repository.TransactionRepository;
import com.bank.BankAccount.service.TransactionService;


import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionTests {
	
	@InjectMocks
    private TransactionService transactionService;
	
	@Mock
	private AccountRepository accountRepository;
	
	@Mock
	private TransactionRepository transactionRepository;
	
	
	
	@Test(expected=CustomNotFoundException.class)
    public void testAccountNotFound() throws Exception {
		when(accountRepository.findById(1L)).thenReturn(Optional.empty());
		transactionService.createTransaction(1L, null);
	}

	@Test
	public void testGetPostBalanceCredit() throws Exception {
		
		Transaction transaction =new Transaction();
		transaction.setAmount(100);
		transaction.setTransactionType(TransactionType.CREDIT);
				
		double postBalance = transactionService.getPostBalance(transaction, 100);
		
		Assert.assertEquals(postBalance, 200, 0);
	}
	
	
	@Test
	public void testGetPostBalanceDebit() throws Exception {
		
		Transaction transaction =new Transaction();
		transaction.setAmount(100);
		transaction.setTransactionType(TransactionType.DEBIT);
				
		double postBalance = transactionService.getPostBalance(transaction, 100);
		
		Assert.assertEquals(postBalance, 0, 0);
	}
	
	
	@Test(expected=BankAccountException.class)
	public void testGetPostBalanceDebitInsufficientBalance() throws Exception {
		
		Transaction transaction =new Transaction();
		transaction.setAmount(100);
		transaction.setTransactionType(TransactionType.DEBIT);
				
		transactionService.getPostBalance(transaction, 0);
		
	}
	@Test
	public void testSaveBalanceAccount() throws Exception {
		Account accountBefore = new Account(1L,"DDE",50, null, new ArrayList<Transaction>());
		Account accountAfter = new Account(1L,"DDE",200, null, new ArrayList<Transaction>());
		when(accountRepository.save(accountBefore)).thenReturn(accountAfter);
		Account accountResult = transactionService.saveBalanceAccount(accountBefore, 200);
		Assert.assertEquals(accountResult.getBalance(), 200, 0);
	}

	
	

}
