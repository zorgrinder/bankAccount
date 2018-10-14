package com.bank.BankAccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.BankAccount.common.ApiResponse;
import com.bank.BankAccount.repository.ClientRepository;


@RestController
public class ClientController {
	
	@Autowired
    private ClientRepository clientRepository;
	
	
	@GetMapping("/clients")
    public ApiResponse getClients() {
		return new ApiResponse(0, "SUCCESS",null);
	}

}
