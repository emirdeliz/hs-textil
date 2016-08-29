package br.com.hs.model.entity;


public class MaterialCompra extends EntityObject{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	private Material material;
	
	private Integer quantidade;
	
	private Float valorUnitario;
	
	private Float valorTotal;	
	
	public MaterialCompra(){
		
	}
		
	public MaterialCompra(Material material, Integer quantidade,
			Float valorUnitario, Float valorTotal) {
		super();
		this.material = material;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
	}

	public Material getMaterial() {
		return material;
	}
	
	public void setMaterial(Material material) {
		this.material = material;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Float getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}	
}
