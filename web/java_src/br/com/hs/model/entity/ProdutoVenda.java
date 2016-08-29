package br.com.hs.model.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class ProdutoVenda extends EntityObject{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	private Produto produto;
	
	private Integer quantidade;
	
	private Float valorUnitario;
	
	private Float valorTotal;	
	
	public ProdutoVenda(){
		
	}
		
	public ProdutoVenda(Produto produto, Integer quantidade,
			Float valorUnitario, Float valorTotal) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
	}

	@OneToOne
	@Cascade(value=CascadeType.SAVE_UPDATE)
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
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
