package com.tswe.formation3.dao;

import com.tswe.formation3.entities.Client;

public class ClientDAO 
	extends ObjectDAO
	implements IDAO<Client> {

//	public Client creer(Client c )
	
	public Client getById(int id) {
		// On simule la création d'un client qui arriverait d'un appel SQL
		Client c = new Client();
		c.setId(12);
		c.setName("SPORTELLI");
		c.setCodeClient("901333");
		return c;
	}

	@Override
	public Client create(Client client) {
		demarrerTransaction();
		client.setId(123);
		return client;
	}

	@Override
	public void delete(Client x) {
		//TODO: Suppression en base de données
	}

	@Override
	public Client update(Client x) {
		//TODO: Modification en base de données
		return x;
	}

	@Override
	public void connect() {
		System.out.println("LE CLIENT SE CONNECTE");
	}

}
