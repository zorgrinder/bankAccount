package com.bank.BankAccount.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bank.BankAccount.model.Transaction;

@Transactional(readOnly = true)
public interface TransactionRepository  extends JpaRepository<Transaction, Long> {
	
	@Query("select trans from Transaction trans where trans.account.accountId = :accountId")
	List<Transaction> findByAccountId(@Param("accountId") Long clientId);

}
