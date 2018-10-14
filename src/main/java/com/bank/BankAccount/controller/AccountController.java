package com.bank.BankAccount.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.BankAccount.common.ApiResponse;
import com.bank.BankAccount.dto.AccountDTO;
import com.bank.BankAccount.model.Account;
import com.bank.BankAccount.repository.AccountRepository;


@RestController
public class AccountController {
	
	@Autowired
    private AccountRepository accountRepository;
	
	
	@GetMapping("/account") 
    public ApiResponse getAccount(@RequestParam Long clientId) {
		List<Account> accounts = accountRepository.findByClientId(clientId);
		if(accounts.isEmpty()) {
			return new ApiResponse(0, "Aucun élémenent trouvé",accounts);
		}else {
			ModelMapper modelMapper = new ModelMapper();
			java.lang.reflect.Type targetListType = new TypeToken<List<AccountDTO>>() {}.getType();
		    List<AccountDTO> AccountsDTO = modelMapper.map(accounts, targetListType);
			return new ApiResponse(0, "SUCCESS",AccountsDTO);
		}
    }

}
