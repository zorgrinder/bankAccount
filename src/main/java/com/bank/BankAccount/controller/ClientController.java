package com.bank.BankAccount.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.BankAccount.common.ApiResponse;
import com.bank.BankAccount.dto.ClientDTO;
import com.bank.BankAccount.model.Client;
import com.bank.BankAccount.repository.ClientRepository;


@RestController
public class ClientController {
	
	@Autowired
    private ClientRepository clientRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/clients")
    public ApiResponse getClients() {
		List<Client> clients = clientRepository.findAll();
		if(clients.isEmpty()) {
			return new ApiResponse(0, "Aucun élémenent trouvé",clients);
		}
		java.lang.reflect.Type targetListType = new TypeToken<List<ClientDTO>>() {}.getType();
		List<ClientDTO> clientsDTO = modelMapper.map(clients, targetListType);
		return new ApiResponse(0, "SUCCESS",clientsDTO);
	}

}
