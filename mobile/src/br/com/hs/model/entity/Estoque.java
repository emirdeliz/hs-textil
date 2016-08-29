package br.com.hs.model.entity;


public class Estoque extends EntityObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int tipo;

	private int qtd;	
	
	private int item;
	
	public Estoque(){
		
	}

	public Estoque(int tipo, int qtd, int item) {
		super();
		this.tipo = tipo;
		this.qtd = qtd;
		this.item = item;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}
}