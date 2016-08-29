package br.com.hs.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class FormaPagamento extends EntityObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;

	private String nome;

	private String descricao;
	
	private Boolean inativo;
	
	public FormaPagamento(){
		
	}

	public FormaPagamento(String id, String nome, String descricao, Boolean inativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.inativo = inativo;
	}
	
	@Column(unique=true)
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