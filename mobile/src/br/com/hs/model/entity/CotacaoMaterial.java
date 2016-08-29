package br.com.hs.model.entity;

import java.util.Date;

public class CotacaoMaterial extends EntityObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Material material;

	private Float valor;

	private String observacao;

	private Date data;	
	
	public CotacaoMaterial(){
		
	}
		
	public CotacaoMaterial(Material material, Float valor, String observacao, Date data) {
		super();
		this.material = material;
		this.valor = valor;
		this.observacao = observacao;
		this.data = data;
	}
	
	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
