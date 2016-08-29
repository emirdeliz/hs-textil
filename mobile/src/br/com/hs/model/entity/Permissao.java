package br.com.hs.model.entity;


public class Permissao extends EntityObject{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Boolean permitido;
	public String menu;
	
	public Permissao(){
		
	}
	
	public Permissao(Boolean permitido, String menu) {
		super();
		this.permitido = permitido;
		this.menu = menu;
	}
	public Boolean getPermitido() {
		return permitido;
	}
	public void setPermitido(Boolean permitido) {
		this.permitido = permitido;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}	
	
}
