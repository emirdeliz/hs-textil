package br.com.hs.model.entity;

import java.util.Date;
import java.util.List;

public class Produto extends EntityObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;

	private String nome;

	private String descricao;

	private Float valor;
	
	private UnidadeMedida unidadeMedida;
	
	private Float qtdEstoque;
	
	private List<MaterialProduto> materiais;
	
	private Date ultimaVenda;
	
	private Boolean inativo;
	
	public Produto(){
		
	}	

	public Produto(String id, String nome, String descricao, Float valor,
			UnidadeMedida unidadeMedida, Float qtdEstoque, List<MaterialProduto> materiais, Date ultimaVenda, Boolean inativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.unidadeMedida = unidadeMedida;
		this.qtdEstoque = qtdEstoque;
		this.materiais = materiais;
		this.ultimaVenda = ultimaVenda;
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

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
		
	public UnidadeMedida getUnidade() {
		return unidadeMedida;
	}

	public void setUnidade(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Float getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Float qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}		
		
	public List<MaterialProduto> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<MaterialProduto> materiais) {
		this.materiais = materiais;
	}
		
	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Date getUltimaVenda() {
		return ultimaVenda;
	}

	public void setUltimaVenda(Date ultimaVenda) {
		this.ultimaVenda = ultimaVenda;
	}
	
	public Boolean getInativo() {
		return inativo;
	}

	public void setInativo(Boolean inativo) {
		this.inativo = inativo;
	}
	
}