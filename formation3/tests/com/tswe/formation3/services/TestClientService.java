package com.tswe.formation3.services;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tswe.formation3.dao.ClientDAO;
import com.tswe.formation3.entities.Client;

public class TestClientService {
	
	private ClientService clientService;
	
	@Before
	public void setup(){
		this.clientService = new ClientService();
	}
	
	@Test 
	public void testExportClients(){
		// On récupère l'ensemble des clients
		List<Client> clients = new ClientDAO().findAll();
		this.clientService.exporterClients("file/export.csv", clients);
	}
	
	@Test
	public void testImporterClients(){
		List<Client> clients = this.clientService.importerClients("file/clients.csv");
		System.out.println(clients);
	}

}
