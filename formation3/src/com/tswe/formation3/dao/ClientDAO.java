package com.tswe.formation3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	public void delete(Client client) {
		try {
			// Charger le driver JDBC PostGreSQL
			Class.forName("org.postgresql.Driver");
			
			String login = "postgres";
			String password = "postgres";
			String url = "jdbc:postgresql://localhost:5433/postgres";
			
			// Connexion à la base
			Connection connection = DriverManager.getConnection(url, login, password);
			
			String sql = "DELETE FROM users where id= ?";
			PreparedStatement st = 
						connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// Je définis les paramètres de ma requête SQL
			st.setInt(1, client.getId());
			
			// J'exécute la requête SQL
			st.execute();
						
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER PGSQL NON TROUVE");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("COMMUNICATION AVEC LA BASE IMPOSSIBLE");
		}		
		
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
	
	public List<Client> findAll() {
		List<Client> clients = new ArrayList<Client>();
		
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
					st.executeQuery("SELECT id,name,codeclient from users");
			
			while(rs.next()){
				Integer tmpId= rs.getInt("id");
				String tmpName= rs.getString("name");
				String tmpCodeClient = rs.getString("codeclient");
				clients.add(new Client(tmpId, tmpName, tmpCodeClient));
			}
						
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER PGSQL NON TROUVE");
		} catch (SQLException e) {
			System.out.println("COMMUNICATION AVEC LA BASE IMPOSSIBLE");
		}		
		
		return clients;
	}

	public Client create(Client client) {		
		try {
			// Charger le driver JDBC PostGreSQL
			Class.forName("org.postgresql.Driver");
			
			String login = "postgres";
			String password = "postgres";
			String url = "jdbc:postgresql://localhost:5433/postgres";
			
			// Connexion à la base
			Connection connection = DriverManager.getConnection(url, login, password);
			
			String sql = "INSERT INTO users(name,codeclient) " + 
					"values( ? , ? )";
			PreparedStatement st = 
						connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// Je définis les paramètres de ma requête SQL
			st.setString(1, client.getName());
			st.setString(2, client.getCodeClient());
			
			// J'exécute la requête SQL
			st.execute();
							
			// Récupérer l'id de l'objet créé
			ResultSet rs = st.getGeneratedKeys();
		
			int generatedKey = 0;
			if (rs.next()) {
			    generatedKey = rs.getInt(1);
			}
			// On l'affecte au client
			client.setId(generatedKey);
						
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER PGSQL NON TROUVE");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("COMMUNICATION AVEC LA BASE IMPOSSIBLE");
		}		
		
		return client;
	}
}
