package com.bank.BankAccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.BankAccount.common.ApiResponse;
import com.bank.BankAccount.repository.AccountRepository;


@RestController
public class AccountController {
	
	@Autowired
    private AccountRepository accountRepository;
	
	
	@GetMapping("/account") 
    public ApiResponse getAccount(@RequestParam Long clientId) {
			return new ApiResponse(0, "SUCCESS",null);
		
    }

}
