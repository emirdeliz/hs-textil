package br.com.hs.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
public class Fornecedor extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nomeFantasia;

	private List<Material> materiais;

	private String usuario;

	private String senha;
	
	public Fornecedor(){
		
	}

	public Fornecedor(String id, String nome, String endereco, String contato,
			String email, String nomeFantasia, List<Material> materiais,
			String usuario, String senha, Boolean inativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
		this.email = email;
		this.nomeFantasia = nomeFantasia;
		this.materiais = materiais;
		this.usuario = usuario;
		this.senha = senha;
		this.inativo = inativo;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	@ManyToMany(fetch=FetchType.EAGER)	
	public List<Material> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<Material> materiais) {
		this.materiais = materiais;
	}
	
	@Column(unique=true)
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}