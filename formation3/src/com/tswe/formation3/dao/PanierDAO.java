package com.tswe.formation3.dao;

import java.util.ArrayList;

import com.tswe.formation3.entities.Client;
import com.tswe.formation3.entities.Panier;
import com.tswe.formation3.entities.Produit;

public class PanierDAO implements IPanierDAO {

	/* (non-Javadoc)
	 * @see com.tswe.formation3.dao.IPanierDAO#ajoute(com.tswe.formation3.entities.Produit, com.tswe.formation3.entities.Panier)
	 */
	@Override
	public void ajoute(Produit produit, Panier panier){
		// ajoute le produit p au panier
		panier.getProduits().add(produit);
	}

	/* (non-Javadoc)
	 * @see com.tswe.formation3.dao.IPanierDAO#creer(com.tswe.formation3.entities.Client)
	 */
	@Override
	public Panier creer(Client client) {
		Panier panier = new Panier();
		ArrayList<Produit> tableauDeProduitsVide = new ArrayList<Produit>();
		panier.setProduits(tableauDeProduitsVide);
		panier.setProprietaire(client);
		return panier;
	}

	/* (non-Javadoc)
	 * @see com.tswe.formation3.dao.IPanierDAO#supprime(com.tswe.formation3.entities.Produit, com.tswe.formation3.entities.Panier)
	 */
	@Override
	public void supprime(Produit produit, Panier panier) {
		panier.getProduits().remove(produit);
	}


	/* (non-Javadoc)
	 * @see com.tswe.formation3.dao.IPanierDAO#create(com.tswe.formation3.entities.Panier)
	 */
	@Override
	public Panier create(Panier x) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.tswe.formation3.dao.IPanierDAO#delete(com.tswe.formation3.entities.Panier)
	 */
	@Override
	public void delete(Panier x) {
		System.out.println("Panier avec l'id" + x.getId() + " supprimé");
	}

	/* (non-Javadoc)
	 * @see com.tswe.formation3.dao.IPanierDAO#update(com.tswe.formation3.entities.Panier)
	 */
	@Override
	public Panier update(Panier x) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.tswe.formation3.dao.IPanierDAO#connect()
	 */
	@Override
	public void connect() {
		System.out.println("LE PANIER SE CONNECTE");
	}

}
