package com.tswe.formation3.entities;

public class User {

	private Integer id;
	private String email;
	private String password;
	
	
	public User() {
		super();
	}
	public User(Integer id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean equals(User u2) {
		boolean eq = true;
		if (!this.id.equals(u2.getId()))
			eq = false;
		if (!this.email.equals(u2.getEmail()))
			eq = false;
		if (!this.password.equals(u2.getPassword()))
			eq = false;
		return eq;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
}
