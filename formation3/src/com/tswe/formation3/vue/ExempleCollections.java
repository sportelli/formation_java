package com.tswe.formation3.vue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tswe.formation3.entities.User;

public class ExempleCollections {

	public static void main(String[]args){
		User u = new User(1 , "a@b.com", "1234");
		User u2 = new User(2 , "b@b.com", "abc");
		
		// List
		System.out.println("LIST");
		List<User> utilisateurs = new ArrayList<User>();
		utilisateurs.add(u);
		utilisateurs.add(u2);
		utilisateurs.add(u2);
		System.out.println(utilisateurs);	
		System.out.println("Taille: " + utilisateurs.size());
		System.out.println("----");
		// Set 
		System.out.println("SET");
		Set<User> utilisateursUniques = new HashSet<User>();
		utilisateursUniques.add(u);
		utilisateursUniques.add(u2);
		utilisateursUniques.add(u2);
		System.out.println(utilisateursUniques);
		for (User uTmp : utilisateursUniques){
			System.out.println(uTmp);
		}
	
		System.out.println(utilisateursUniques.size());
		System.out.println("---");
		
		// Map 
		System.out.println("MAP");
		Map<String, User> utilisateursTab = new HashMap<String, User>();
		utilisateursTab.put("courant", u);
		utilisateursTab.put("courant", u2);
		System.out.println(utilisateursTab.get("courant"));
		for (String key : utilisateursTab.keySet()){
			System.out.println(utilisateursTab.get(key));
		}
	}
}
