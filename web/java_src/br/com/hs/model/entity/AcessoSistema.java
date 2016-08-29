package br.com.hs.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class AcessoSistema extends EntityObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;

	private String nome;

	private String descricao;
	
	private List<Permissao> permissoes;
	
	public AcessoSistema(){
		
	}
	
	public AcessoSistema(String id, String nome, String descricao, List<Permissao> permissoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.permissoes = permissoes;
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
	
	@ManyToMany(fetch=FetchType.EAGER)
	@Cascade(value={CascadeType.ALL})
	public List<Permissao> getPermissoes() {
		return permissoes;
	}
	
	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}	
}