package com.bank.BankAccount.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bank.BankAccount.model.Account;

@Transactional(readOnly = true)
public interface AccountRepository  extends JpaRepository<Account, Long> {
	
	@Query("select acnt from Account acnt where acnt.client.clientId = :clientId")
	List<Account> findByClientId(@Param("clientId") Long clientId);

}

