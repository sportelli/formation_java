package com.tswe.formation3.dao;

import java.util.ArrayList;

import com.tswe.formation3.entities.Client;
import com.tswe.formation3.entities.Facture;
import com.tswe.formation3.exceptions.FactureIdNegativeException;

public class FactureDAO implements IDAO<Facture> {
	
//	public Facture creer(Facture )

	public ArrayList<Facture> getByClient(Client c) {
		// On simule la création d'une facture 
		// avec des infos qui devraient venir de la base de données
		ArrayList<Facture> tab = new ArrayList<>();
		
		Facture f = new Facture();
		f.setId(993);
		f.setObjet("Facture pour les crayons");
		f.setMontant(99.2);
		tab.add(f);
		
		f = new Facture();
		f.setId(994);
		f.setObjet("Facture pour les cahiers");
		f.setMontant(11.2);
		tab.add(f);
		
		return tab;
	}


	@Override
	public Facture create(Facture x) {
		//TODO: Creer la facture en BDD
		x.setId(123);
		return x;
	}

	@Override
	public void delete(Facture x) throws FactureIdNegativeException {
		if (x.getId() < 0)
			throw new FactureIdNegativeException("Impossible de supprimer facture");
		else {
			//TODO: Supprimer en base de données
		}
	}

	@Override
	public Facture update(Facture x) {
		// TODO : Mettre à jour la facture
		return x;
	}

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		
	}

}
