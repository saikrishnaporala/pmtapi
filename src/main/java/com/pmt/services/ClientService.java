package com.pmt.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.models.Client;
import com.pmt.repos.ClientRepo;

@Service
public class ClientService {

	@Autowired
	private ClientRepo repo;

	// fetching all clients
	public List<Client> getAllClients() {
		List<Client> objs = (List<Client>) repo.findAll();
		return objs;
	}

	public Client getComp(UUID uuid) {
		Client comp = repo.getOne(uuid);
		return comp;
	}

	// fetching client by id
	public Client getClient(UUID id) {
		Client comp = repo.getOne(id);
		System.out.println(comp.getId());
		return comp;
	}

	// inserting client
	public UUID addClient(Client c) {
		Client res = repo.save(c);
		Date dtCreated = new Date();
		c.setCreated(dtCreated);
		return res.getId();
	}

	// updating client by id
	public void updateClient(Client client, UUID id) {
		if (id == client.getId()) {
			repo.save(client);
		}
	}

	// deleting all clients
	public void deleteAllClients() {
		repo.deleteAll();
	}

	// deleting client by id
	public void deleteClientByID(UUID id) {
		repo.deleteById(id);
	}

	// patching/updating client by id
	public void patchClient(Client obj, UUID id) {
		if (id == obj.getId()) {
			repo.save(obj);
		}
	}
}
