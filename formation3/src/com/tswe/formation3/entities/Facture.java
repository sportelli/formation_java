package com.tswe.formation3.entities;

import java.util.ArrayList;

public class Facture {
	
	private Integer id;
	private String objet;
	private Double montant;	
	private ArrayList<FactureLigne> lignes;
	private String codeClient;
	private Integer idClient;
	private String nomClient;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	@Override
	public String toString() {
		return "Facture [id=" + id + ", objet=" + objet 
				+ ", montant=" + montant + ",client= " + nomClient + "]\n" + lignes;
	}
	public ArrayList<FactureLigne> getLignes() {
		return lignes;
	}
	public void setLignes(ArrayList<FactureLigne> lignes) {
		this.lignes = lignes;
	}
	public String getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
	}
	public Integer getIdClient() {
		return idClient;
	}
	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	
	
}
