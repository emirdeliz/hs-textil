package br.com.hs.model.entity;

public class Category {

	private int oid;
	private String id;
	private String name;
	private String description;	
	
	public Category(){
		
	}
	
	public Category(String id, String name, String description){
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 
}