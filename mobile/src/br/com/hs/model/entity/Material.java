package br.com.hs.model.entity;


public class Material extends EntityObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;

	private String nome;

	private String descricao;
	
	private UnidadeMedida unidadeMedida;
	
	private Float qtdEstoque;
	
	private Integer qtdMinimaEstoque;
	
	private Boolean inativo;
	
	public Material(){
		
	}
		
	public Material(String id, String nome, String descricao, UnidadeMedida unidadeMedida, Float qtdEstoque, Integer qtdMinimaEstoque, Boolean inativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.unidadeMedida = unidadeMedida;
		this.qtdEstoque = qtdEstoque;
		this.qtdMinimaEstoque = qtdMinimaEstoque;
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

	public Integer getQtdMinimaEstoque() {
		return qtdMinimaEstoque;
	}

	public void setQtdMinimaEstoque(Integer qtdMinimaEstoque) {
		this.qtdMinimaEstoque = qtdMinimaEstoque;
	}	
	
	public Boolean getInativo() {
		return inativo;
	}

	public void setInativo(Boolean inativo) {
		this.inativo = inativo;
	}
	
}