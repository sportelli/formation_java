package com.tswe.formation3.entities;

import java.util.ArrayList;

public class Panier {

	private Integer id;
	private ArrayList<Produit> produits;
	private Client proprietaire;
	
	private static Integer compteur= 0;
	
	public ArrayList<Produit> getProduits() {
		return produits;
	}
	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}
	public Client getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Client proprietaire) {
		this.proprietaire = proprietaire;
	}
	@Override
	public String toString() {
		String s = "Panier \n "
					+ "Proprietaire=" + proprietaire + "\n"
					;
		
		s+= "Produits: \n";
		for (Produit p: produits){			
			s += "- " + p + "\n";
		}
		
		s+= "Total: " + this.getTotal();
		
		return s;
	}
	
	public Double getTotal() {
		Double total = 0.0;
		for (Produit p : produits)
			total += p.getPrix();
		
		return total;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public static Integer getCompteur() {
		return compteur;
	}
	public static void setCompteur(Integer compteur) {
		Panier.compteur = compteur;
	}
	
	public Panier(){
		System.out.println("CREATION D'UN PANIER");
		Panier.compteur++;
	}
	
}
