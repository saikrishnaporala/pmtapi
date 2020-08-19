package com.pmt.controllers;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pmt.models.Client;
import com.pmt.services.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	static final Logger logger = LogManager.getLogger(ClientController.class.getName());

	@Autowired
	private ClientService clientService;

	// displaying list of all clients
	@GetMapping("/")
	public List<Client> getAllClient() {
		return clientService.getAllClients();
	}

	// displaying client by id
	@GetMapping("/{id}")
	public Client getClient(@PathVariable UUID id) {
		return clientService.getClient(id);
	}

	// inserting client
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UUID> addClients(@RequestBody Client client) {
		return new ResponseEntity<>(clientService.addClient(client), HttpStatus.CREATED);
	}

	// updating client by id
	@PutMapping("/{id}")
	public void updateClient(@RequestBody Client e, @PathVariable UUID id) {
		clientService.updateClient(e, id);
	}

	// deleting all clients
	@DeleteMapping("/")
	public void deleteAllClients() {
		clientService.deleteAllClients();
	}

	// deleting client by id
	@DeleteMapping("/{id}")
	public void deleteClientByID(@RequestBody Client e, @PathVariable UUID id) {
		clientService.deleteClientByID(id);
	}

	// updating/ patching client by id
	@PatchMapping("/{id}")
	public void patchClientByID(@RequestBody Client e, @PathVariable UUID id) {
		clientService.patchClient(e, id);
	}
}
