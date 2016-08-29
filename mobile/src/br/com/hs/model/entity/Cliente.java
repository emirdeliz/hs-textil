package br.com.hs.model.entity;


public class Cliente extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String informacoesAdicionais;
	
	private String potencial;
	
	private Representante representante;
		
	public Cliente(){
		
	}	
	
	public Cliente(String id, String nome, String endereco, String contato,
			String email, String informacoesAdicionais, String potencial, Representante representante, Boolean inativo) {

		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
		this.email = email;
		this.informacoesAdicionais = informacoesAdicionais;
		this.potencial = potencial;
		this.representante = representante;
		this.inativo = inativo;
	}

	public String getInformacoesAdicionais() {
		return informacoesAdicionais;
	}

	public void setInformacoesAdicionais(String informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
	}

	public String getPotencial() {
		return potencial;
	}

	public void setPotencial(String potencial) {
		this.potencial = potencial;
	}
			
	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}	
			
}