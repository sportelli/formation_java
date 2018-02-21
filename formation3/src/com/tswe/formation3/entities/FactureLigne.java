package com.tswe.formation3.entities;

public class FactureLigne {

	private Integer id;
	private String designation;
	private Double prix;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "FactureLigne [id=" + id + ", designation=" + designation + ", prix=" + prix + "]";
	}
	
	
}
