package com.bank.BankAccount.service;

import java.util.Optional;

import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.BankAccount.dto.TransactionReqDTO;
import com.bank.BankAccount.dto.TransactionResDTO;
import com.bank.BankAccount.exception.BankAccountException;
import com.bank.BankAccount.exception.CustomNotFoundException;
import com.bank.BankAccount.model.Account;
import com.bank.BankAccount.model.Transaction;
import com.bank.BankAccount.model.TransactionType;
import com.bank.BankAccount.repository.AccountRepository;
import com.bank.BankAccount.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
    private AccountRepository accountRepository;
	
	@Autowired
    private TransactionRepository transactionRepository;
	
	@Transactional(rollbackOn=Exception.class)
	public TransactionResDTO createTransaction(Long accountId, TransactionReqDTO transactionDTO) throws Exception {
		
		Optional<Account> optionalAccount = accountRepository.findById(accountId);
		
		if(optionalAccount.isPresent()) {
			Account account = optionalAccount.get();
			
			ModelMapper modelMapper = new ModelMapper();
			Transaction transaction = modelMapper.map(transactionDTO, Transaction.class);
			
			double postBalance = getPostBalance(transaction,account.getBalance());
			
			Account accountUpdated = saveBalanceAccount(account, postBalance);
			
			transaction.setAccount(accountUpdated);
			
			Transaction transactionUpdated = savePostBalanceTransaction(transaction, postBalance);
			return modelMapper.map(transactionUpdated, TransactionResDTO.class);
			
			
		}else {
			throw new CustomNotFoundException(accountId.toString(),"ACCOUNT");
		}
		
	}
	
	public double getPostBalance(Transaction transaction, double balance) {
		
		if(transaction.getTransactionType().equals(TransactionType.DEBIT)) {
			if(transaction.getAmount()>balance) {
				throw new BankAccountException("Votre solde est insuffisant");
			}
			return balance-transaction.getAmount();
			
		}else{
			return balance+transaction.getAmount();
			
		}
	}
	public Account saveBalanceAccount(Account account, double balance) {
		account.setBalance(balance);
		return accountRepository.save(account);
	}
	
	public Transaction savePostBalanceTransaction(Transaction transaction, double postBalance) {
		transaction.setPostBalance(postBalance);
		return transactionRepository.save(transaction);
	}
}
