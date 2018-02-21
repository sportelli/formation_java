package com.tswe.formation3.vue;

import java.util.HashMap;
import java.util.Map;

import com.tswe.formation3.entities.User;

public class ExempleMap {

	public static void main(String[]arrgs){
		// Objectif : stocker un utilisateur u
		// dans une map à la clé "utilisateur_courant"
		
		Map<String, User> data = new HashMap<String,User>();
		User u = new User(1, "a@b.com", "123");
		
		// Insère une valeur dans ma Map
		data.put("utilisateur_courant", u);
		data.put("dernier_utilisateur_enregistre", u);
		
		System.out.println(data.get("utilisateur_courant").getEmail());
	}
	
}








