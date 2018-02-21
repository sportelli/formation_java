package com.tswe.formation3.entities;

public class Produit {
	private Integer id;
	private String objet;
	private Double prix;
	
	public Produit() {
	}
	
	public Produit(Integer id, String objet, Double prix) {
		super();
		this.id = id;
		this.objet = objet;
		this.prix = prix;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
	@Override
	public String toString() {
		return objet + " -  " + prix + "€";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
