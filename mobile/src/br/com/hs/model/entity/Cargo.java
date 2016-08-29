package br.com.hs.model.entity;


public class Cargo extends EntityObject{
	/**
	 * 
	  */
	private static final long serialVersionUID = 1L;
	
	private String id;

	private String nome;

	private String descricao;
	
	private Boolean inativo;
	
	public Cargo(){
		
	}
	
	public Cargo(String id, String nome, String descricao, Boolean inativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.inativo = inativo;
	}
		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getInativo() {
		return inativo;
	}

	public void setInativo(Boolean inativo) {
		this.inativo = inativo;
	}
}