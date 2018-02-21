package com.tswe.formation3.dao;

import com.tswe.formation3.entities.Client;
import com.tswe.formation3.entities.Panier;
import com.tswe.formation3.entities.Produit;

public interface IPanierDAO extends IDAO<Panier> {

	void ajoute(Produit produit, Panier panier);

	Panier creer(Client client);

	void supprime(Produit produit, Panier panier);

	Panier create(Panier x);

	void delete(Panier x);

	Panier update(Panier x);

	void connect();

}