package com.bank.BankAccount.exception;

import javax.persistence.OptimisticLockException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bank.BankAccount.common.ApiResponse;


@RestControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(CustomNotFoundException.class)
	public ApiResponse handleCustomNotFoundException(CustomNotFoundException ex) {
		ApiResponse apiErrorResponse = new ApiResponse(1,ex.getMessage(),"");
		return apiErrorResponse;
	}
	
	@ExceptionHandler(BankAccountException.class)
	public ApiResponse handleBankAccountException(BankAccountException ex) {
		ApiResponse apiErrorResponse = new ApiResponse(1,ex.getMessage(),"");
		return apiErrorResponse;
		
	}
	
	@ExceptionHandler(OptimisticLockException.class)
	public ApiResponse handleOptimisticLockException(OptimisticLockException ex) {
		ApiResponse apiErrorResponse = new ApiResponse(1,"Probleme de synchronisation, veuillez réessayer plus tard",ex.getMessage());
		return apiErrorResponse;
		
	}
}
