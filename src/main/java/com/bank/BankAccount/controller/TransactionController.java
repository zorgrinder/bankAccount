package com.bank.BankAccount.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bank.BankAccount.common.ApiResponse;
import com.bank.BankAccount.dto.TransactionDTO;
import com.bank.BankAccount.repository.TransactionRepository;
import com.bank.BankAccount.service.TransactionService;

@RestController
public class TransactionController extends ResponseEntityExceptionHandler{

	@Autowired
    private TransactionRepository transactionRepository;
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/transaction")
    public ApiResponse getTransactions(@RequestParam("accountId") Long accountId) {
		return new ApiResponse(0, "SUCCESS",null); 
    }
	
	@PostMapping("/transaction")
    public ApiResponse createTransaction(@RequestParam("accountId") Long accountId,  
    		@Valid @RequestBody TransactionDTO transactionDTO) {
		return new ApiResponse(0, "SUCCESS",null);
    }
}
