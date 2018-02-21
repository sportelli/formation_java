package com.tswe.formation3.vue;

import com.tswe.formation3.entities.User;

public class Comparaison {
	
	public static void main (String[] args){
		User u = new User(1, "toto@titi.com", "toto");
		User u2 = new User(1, "toto@titi.com", "toto");
		User u3 = u; 
		
		System.out.println(u);
		System.out.println(u2);
		System.out.println(u3);
		
		if (u != u2){
			// vrai ou faux ?
			System.out.println("PAS EGAUX");
		}
		
		if (u.equals(u2)){
			System.out.println("EGAUX");
		}
		
	}

}
