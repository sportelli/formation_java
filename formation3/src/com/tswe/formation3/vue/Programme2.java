package com.tswe.formation3.vue;

import java.util.ArrayList;

import com.tswe.formation3.entities.Client;
import com.tswe.formation3.entities.Facture;
import com.tswe.formation3.entities.Panier;
import com.tswe.formation3.entities.Produit;
import com.tswe.formation3.exceptions.PanierNonTrouveException;
import com.tswe.formation3.services.FactureService;

/**
 * Cette classe permet de tester la création d'une facture
 * @author felix
 *
 */
public class Programme2 {

	public static void main(String[] args){
		try {			
			// Créer un "faux" panier
			Panier panier = new Panier();
			panier.setId(2);

			// Ajout des "faux" produits
			ArrayList<Produit> produits = new ArrayList<Produit>();
			produits.add(new Produit(1, "crayon", 1.0));
			produits.add(new Produit(2, "papier", 2.0));
			panier.setProduits(produits);

			// Ajout d'un "faux" client pour la facture
			Client proprietaire = new Client();
			proprietaire.setCodeClient("2123");
			proprietaire.setId(1111);
			proprietaire.setName("SPORTELLI Felix");
			panier.setProprietaire(proprietaire);
			Facture f = new FactureService().creerFactureDepuisPanier(panier);
			System.out.println(f);
		} catch (PanierNonTrouveException pe) {
			System.out.println("Panier non trouvé");
		}
	}

}
