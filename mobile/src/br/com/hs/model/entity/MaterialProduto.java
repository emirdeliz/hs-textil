package br.com.hs.model.entity;


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
