package com.tswe.formation3.vue;

import com.tswe.formation3.entities.Panier;

public class ExempleStatic {

	public static void main(String[] args) {
		Panier p1 = new Panier();
		Panier p2 = new Panier();
		
		p1.setId(1); // Attributs d'objets
		Panier.getCompteur();			 // Attributs de classe (partagés par tous les objets d'1 classe)
		
		System.out.println(Panier.getCompteur());
	
		System.out.println(Math.PI);
		
	}

}
