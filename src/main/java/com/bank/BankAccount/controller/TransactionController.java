package com.bank.BankAccount.controller;

import java.util.List;


import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bank.BankAccount.common.ApiResponse;
import com.bank.BankAccount.dto.TransactionReqDTO;
import com.bank.BankAccount.dto.TransactionResDTO;
import com.bank.BankAccount.model.Transaction;
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
		List<Transaction> transactions = transactionRepository.findByAccountId(accountId);
		if(transactions.isEmpty()) {
			return new ApiResponse(0, "Aucun élémenent trouvé",transactions);
		}

		ModelMapper modelMapper = new ModelMapper();
		java.lang.reflect.Type targetListType = new TypeToken<List<TransactionResDTO>>() {}.getType();
	    List<TransactionResDTO> transactionOutDTO = modelMapper.map(transactions, targetListType);
		return new ApiResponse(0, "SUCCESS",transactionOutDTO); 
    }
	
	@PostMapping("/transaction")
    public ApiResponse createTransaction(@RequestBody TransactionReqDTO transactionDTO, @RequestParam("accountId") Long accountId  
    		) throws Exception{
			TransactionResDTO trans = transactionService.createTransaction(accountId, transactionDTO);
			return new ApiResponse(0, "SUCCESS",trans); 
    }
}
