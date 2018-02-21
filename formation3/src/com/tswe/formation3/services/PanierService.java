package com.tswe.formation3.services;

import com.tswe.formation3.dao.IPanierDAO;
import com.tswe.formation3.dao.PanierDAO;
import com.tswe.formation3.entities.Client;
import com.tswe.formation3.entities.Panier;
import com.tswe.formation3.entities.Produit;
import com.tswe.formation3.exceptions.PanierNonTrouveException;

public class PanierService {
	
	IPanierDAO pDAO = null;
	
	public PanierService(){
		pDAO = new PanierDAO();		
	}
	
	public Panier creer(Client client) {
		Panier p = pDAO.creer(client);
		return p;
	}
	
	public void ajouteProduit (Produit produit , Panier panier){
		pDAO.ajoute(produit, panier);
	}

	public void supprimeProduit(Produit produit, Panier panier) {
		pDAO.supprime(produit, panier);
	}

	public Panier findById(Integer id) throws PanierNonTrouveException {
		// si id < 0 => on jette l'exception
		// sinon on renvoie un Panier
		Panier p = pDAO.findById(id);
		if (p == null) { 
			throw new PanierNonTrouveException();
		}
		return p;
	}

	public void supprimer(Panier panier) {
		// On verifie que le panier existe
		try {
			this.findById(panier.getId());
			pDAO.delete(panier);			
		} catch (PanierNonTrouveException e) {
			e.printStackTrace();
		}
	}

}
