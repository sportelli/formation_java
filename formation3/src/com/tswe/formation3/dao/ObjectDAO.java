package com.tswe.formation3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ObjectDAO {

	private String dbLogin = "";
	private String dbPassword = "";
	private String dbURL ="";

	public ObjectDAO(){
		// TODO: Lire un fichier de configuration
		dbLogin  = "postgres";
		dbPassword = "postgres";
		dbURL = "jdbc:postgresql://localhost:5433/postgres";
	}

	public Connection getConnection(){
		Connection connection = null;
		try {
			// Charger le driver JDBC PostGreSQL
			Class.forName("org.postgresql.Driver");
			
			// Connexion à la base
			connection = DriverManager.getConnection(dbURL, dbLogin, dbPassword);
		} catch(SQLException s) {
			s.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void demarrerTransaction(){
		System.out.println("J'ouvre la transaction");
	}
}
