package br.com.hs.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.IndexColumn;

@Entity
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

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
	
	@ManyToOne
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
	
	@ManyToMany(fetch=FetchType.EAGER)
	@Cascade(value=CascadeType.ALL)
	@IndexColumn(name="index_material")
	public List<MaterialProduto> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<MaterialProduto> materiais) {
		this.materiais = materiais;
	}
	
	@OneToOne
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