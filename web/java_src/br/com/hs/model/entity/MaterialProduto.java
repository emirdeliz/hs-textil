package br.com.hs.model.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class MaterialProduto extends EntityObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Material material;
	
	private Float quantidade;
	
	public MaterialProduto(){
		
	}
	
	public MaterialProduto(Material material, Float quantidade) {
		super();
		this.material = material;
		this.quantidade = quantidade;
	}
	
	@OneToOne
	@Cascade(value=CascadeType.MERGE)
	public Material getMaterial() {		
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}
	
}
