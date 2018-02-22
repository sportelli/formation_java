package com.tswe.formation3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tswe.formation3.entities.Client;
import com.tswe.formation3.entities.User;
import com.tswe.formation3.exceptions.ClientNotFoundException;
import com.tswe.formation3.exceptions.UserNotFoundException;

public class ClientDAO 
	extends ObjectDAO
	implements IDAO<Client> {

//	public Client creer(Client c )
	
	public Client getById(int id) throws ClientNotFoundException {
		// On simule la création d'un client qui arriverait d'un appel SQL
//		Client c = new Client();
//		c.setId(12);
//		c.setName("SPORTELLI");
//		c.setCodeClient("901333");
//		return c;
		
		Client c = null;
		
		try {
			// Charger le driver JDBC PostGreSQL
			Class.forName("org.postgresql.Driver");
			
			String login = "postgres";
			String password = "postgres";
			String url = "jdbc:postgresql://localhost:5433/postgres";
			
			// Connexion à la base
			Connection connection = DriverManager.getConnection(url, login, password);
			
			Statement st = connection.createStatement();
			ResultSet rs = 
					st.executeQuery("SELECT id,name,codeclient from users where id=" + id);
			
			while(rs.next()){
				Integer tmpId= rs.getInt("id");
				String tmpName= rs.getString("name");
				String tmpCodeClient = rs.getString("codeclient");
				c = new Client(tmpId, tmpName, tmpCodeClient);
			}
			
			if (c == null) {
				throw new ClientNotFoundException();				
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER PGSQL NON TROUVE");
		} catch (SQLException e) {
			System.out.println("COMMUNICATION AVEC LA BASE IMPOSSIBLE");
		}		
		
		
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
