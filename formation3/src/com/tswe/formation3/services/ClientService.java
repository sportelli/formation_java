package com.tswe.formation3.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tswe.formation3.dao.ClientDAO;
import com.tswe.formation3.entities.Client;
import com.tswe.formation3.exceptions.ClientNotFoundException;
import com.tswe.formation3.exceptions.UserNotFoundException;

public class ClientService {

	public Client getById(int id) throws ClientNotFoundException {
		// Il faut appeler la méthode getById de ClientDAO
		ClientDAO cDAO = new ClientDAO();
		return cDAO.getById(id);

	}

	public List<Client> importerClients(String nomFichier){
		File f = new File(nomFichier);
		System.out.println(f.getAbsolutePath());
		List<Client> clients = new ArrayList<Client>();
		try {
			FileReader reader = new FileReader(f);
			BufferedReader buffer = new BufferedReader(reader);

			String ligne = buffer.readLine();

			// Tant qu'on a du contenu ...
			while ( ligne != null) {
				String[] contenu = ligne.split(";");
				Client c = new Client();
				for (int i = 0 ; i < contenu.length ; i++){
					switch(i){
					case 0:
						c.setId(Integer.valueOf(contenu[i]));
						break;
					case 1 : 
						c.setName(contenu[i]);
						break;
					case 2 :
						c.setCodeClient(contenu[i]);
						break;
					}
				}

				clients.add(c);
				ligne = buffer.readLine();
			}

			// Fermer le tampon
			buffer.close();
			// Fermer le fichier
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return clients;
	}

	public void exporterClients(String nomFichier, List<Client> clients){

		try {
			File f = new File(nomFichier);
			FileWriter writer = new FileWriter(f);
			BufferedWriter buffer = new BufferedWriter(writer);
			
			for (Client c : clients){
				String ligne = "";
				ligne = c.getId() + ";" + c.getName() + ";" + c.getCodeClient();
				buffer.write(ligne);
				buffer.newLine();
			}
			
			buffer.close();
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
