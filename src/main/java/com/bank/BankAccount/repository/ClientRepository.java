package com.bank.BankAccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.BankAccount.model.Client;

@Transactional(readOnly = true)
public interface ClientRepository extends JpaRepository<Client, Long> {

}

