package com.tswe.formation3.services;

import com.tswe.formation3.dao.ClientDAO;
import com.tswe.formation3.entities.Client;

public class ClientService {

	public Client getById(int id) {
		// Il faut appeler la méthode getById de ClientDAO
		ClientDAO cDAO = new ClientDAO();
		return cDAO.getById(id);
		
	}

}
