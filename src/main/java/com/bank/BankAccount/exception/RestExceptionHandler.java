package com.bank.BankAccount.exception;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.OptimisticLockException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bank.BankAccount.common.ApiResponse;


@ControllerAdvice
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
	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException error) {
		
		Map<String, String> messages = new HashMap<>();

		for (FieldError fieldError : error.getBindingResult().getFieldErrors()) {
			messages.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return new ApiResponse(1, "Erreur dans les valeurs d'entrées", messages);
    }
}
