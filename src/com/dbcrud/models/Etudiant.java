package com.dbcrud.models;

public class Etudiant {
	protected int id;
	protected String name;
	protected String des;
	protected String cin;
	public Etudiant(int id, String name, String des, String cin) {
		this.id = id;
		this.name = name;
		this.des = des;
		this.cin = cin;
	}
	public Etudiant() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", name=" + name + ", des=" + des + ", cin=" + cin + "]";
	}
	
}
