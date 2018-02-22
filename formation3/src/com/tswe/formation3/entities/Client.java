package com.tswe.formation3.entities;

public class Client extends Tiers{
	
	private Integer id;
	private String name;
	private String codeClient;
	
	public Client(Integer tmpId, String tmpName, String tmpCodeClient) {
		this.id = tmpId;
		this.name = tmpName;
		this.codeClient = tmpCodeClient;
	}
	public Client(){
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", codeClient=" + codeClient + "]";
	}
	
	

}
