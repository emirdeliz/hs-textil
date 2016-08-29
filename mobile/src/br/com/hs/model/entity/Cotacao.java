package br.com.hs.model.entity;

import java.util.List;

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
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public List<CotacaoMaterial> getCotacoes() {
		return cotacoes;
	}

	public void setCotacoes(List<CotacaoMaterial> cotacoes) {
		this.cotacoes = cotacoes;
	}
	
}