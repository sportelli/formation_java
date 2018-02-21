package com.tswe.formation3.dao;

public interface IDAO<Styve> {
	// Toute classe qui implémentera IDAO
	// devra avoir cette méthode de définie
//	public void methodeX();
//	public void methodeY(String y);
	public Styve create(Styve x);
	public void delete(Styve x) throws Exception;
	public Styve update(Styve x);
	public void connect();
}
