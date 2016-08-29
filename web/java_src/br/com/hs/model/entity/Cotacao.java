package br.com.hs.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.IndexColumn;

@Entity
public class Cotacao extends EntityObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Fornecedor fornecedor;
	
	private List<CotacaoMaterial> cotacoes;	
	
	public Cotacao(){
		
	}
	
	public Cotacao(Fornecedor fornecedor, List<CotacaoMaterial> cotacoes) {
		super();
		this.fornecedor = fornecedor;
		this.cotacoes = cotacoes;	
	}

	@OneToOne
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	@ManyToMany(fetch=FetchType.EAGER)
	@Cascade(value=CascadeType.ALL)
	@IndexColumn(name="index_cotacoes")
	public List<CotacaoMaterial> getCotacoes() {
		return cotacoes;
	}

	public void setCotacoes(List<CotacaoMaterial> cotacoes) {
		this.cotacoes = cotacoes;
	}
	
}