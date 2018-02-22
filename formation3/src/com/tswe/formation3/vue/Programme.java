package com.tswe.formation3.vue;

import java.util.ArrayList;

import com.tswe.formation3.dao.ClientDAO;
import com.tswe.formation3.dao.PanierDAO;
import com.tswe.formation3.entities.Client;
import com.tswe.formation3.entities.Facture;
import com.tswe.formation3.entities.Panier;
import com.tswe.formation3.entities.PolymorphService;
import com.tswe.formation3.entities.Produit;
import com.tswe.formation3.entities.User;
import com.tswe.formation3.exceptions.FactureIdNegativeException;
import com.tswe.formation3.exceptions.InvalidPasswordException;
import com.tswe.formation3.exceptions.UserNotFoundException;
import com.tswe.formation3.exceptions.ClientNotFoundException;
import com.tswe.formation3.services.ClientService;
import com.tswe.formation3.services.FactureService;
import com.tswe.formation3.services.PanierService;
import com.tswe.formation3.services.UserService;

public class Programme {

	public static void main(String[] args) throws Exception{
		
		// Packages à créer: entities, dao, services
		// Créer une classe Tiers (nom, id)
		// Créer une classe Client qui hérite de Tiers ( code_client )
		// Créer une classe Facture (id, objet, montant)
		// Créer une classe ClientDAO, FactureDAO, FactureService, ClientService
		// 1. Récupérer un client (id = 12)
		
		// Appeler ClientService.getById(Integer)
		//					ClientDAO.getById(Integer)
		ClientService cs = new ClientService();
		Client c = cs.getById(12);
		//System.out.println(c);
		
		// 2. Récupérer toutes les factures d'un client (id = 12)
		FactureService fs = new FactureService();
		ArrayList<Facture> tab = fs.getByClient(c);
		
		// Pour chaque Facture de tab (f) , alors on veut afficher f 
		for (Facture f : tab) // for itératif (foreach)
			System.out.println(f);
		
		// 3. Calcul le CA fait avec ce client
		Double total = fs.calcTotalCA(c);
		System.out.println("Total: " + total);
		
		// 4. Créer une classe Produit (Objet, prix), une classe Panier (array de produits, client)
		// 5. Créer PanierDAO.ajoute(Produit), PanierDAO.supprime(Produit)
		// 6. Créer Panier.toString() qui m'affiche
		/*		- les infos du clients
				- les infos de chaque produit du panier
				- le total du panier
		*/
		
		Produit p = new Produit (1, "Crayon", 1.0);
		Produit p2 = new Produit (2, "Cahier", 2.0);
		
		PanierService panierService = new PanierService();
		Panier panier = panierService.creer(c);
		panierService.ajouteProduit(p, panier);		
		panierService.ajouteProduit(p2, panier);
		
		System.out.println(panier);
		
		panierService.supprimeProduit(p , panier);
		System.out.println(panier);
		
//		PolymorphService ps = new PolymorphService();
//		ps.connect(new PanierDAO());
//		ps.connect(new ClientDAO());
		
		// Appeler depuis Programme la suppression d'une facture (ayant id = -2)
		// Dans FactureDAO, regarder si id > 0
		// Si non, afficher une erreur
		Facture factureASupprimer = new Facture();
		factureASupprimer.setId(-2);
		factureASupprimer.setMontant(100.0);
		factureASupprimer.setObjet("aucune importance");
		
		// On la supprime maintenant: 
		try {
			fs.delete(factureASupprimer);
		} catch (FactureIdNegativeException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			UserService us = new UserService();
			User uToto = us.auth("toto@toto.com", "xx");
			System.out.println(uToto);
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (InvalidPasswordException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
