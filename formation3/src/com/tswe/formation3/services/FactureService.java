package com.tswe.formation3.services;

import java.util.ArrayList;

import com.tswe.formation3.dao.FactureDAO;
import com.tswe.formation3.dao.PanierDAO;
import com.tswe.formation3.entities.Client;
import com.tswe.formation3.entities.Facture;
import com.tswe.formation3.entities.FactureLigne;
import com.tswe.formation3.entities.Panier;
import com.tswe.formation3.entities.Produit;
import com.tswe.formation3.exceptions.FactureIdNegativeException;
import com.tswe.formation3.exceptions.PanierNonTrouveException;

public class FactureService {

	private FactureDAO fDAO = null;
	private PanierService panierService =  null;

	public FactureService(){
		this.fDAO = new FactureDAO();
		this.panierService = new PanierService();
	}

	public ArrayList<Facture> getByClient(Client c) {
		return fDAO.getByClient(c);
	}

	public Double calcTotalCA(Client c) {
		// On récupère les factures
		ArrayList<Facture> factures = this.getByClient(c);

		// On boucle sur chaque facture pour sommer les totaux
		Double total = 0.0;
		for (Facture f : factures)
			total += f.getMontant();

		//		for (Integer i=0; i < factures.size(); i++)
		//			total += factures.get(i).getMontant();

		return total;
	}

	public void delete(Facture factureASupprimer) throws FactureIdNegativeException {
		fDAO.delete(factureASupprimer);
	}

	public Facture creerFactureDepuisPanier(Panier panier) throws PanierNonTrouveException {
		Facture f = null;
		
		// On vérifie que le panier est valide
		panierService.findById(panier.getId());

		Facture factureACreer = new Facture();
		factureACreer.setObjet("Facture à créer");
		factureACreer.setMontant(0.0);
		factureACreer.setLignes(new ArrayList<FactureLigne>());

		// On va parcourir les produits du panier
		// pour en extraire les lignes de facture
		// et calculer le montant total de la facture
		for (Produit p : panier.getProduits()){
			FactureLigne ligne = new FactureLigne();
			ligne.setDesignation(p.getObjet());
			ligne.setPrix(p.getPrix());
			factureACreer.getLignes().add(ligne);

			factureACreer.setMontant( factureACreer.getMontant() + p.getPrix() );
		}

		// Gestion des informations client
		Client client = panier.getProprietaire();
		factureACreer.setCodeClient(client.getCodeClient());
		factureACreer.setIdClient(client.getId());
		factureACreer.setNomClient(client.getName());

		f= fDAO.create(factureACreer);

		panierService.supprimer(panier);

		return f;
	}

}
