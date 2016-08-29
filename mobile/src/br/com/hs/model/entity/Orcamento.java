package br.com.hs.model.entity;

import java.util.Date;
import java.util.List;

public class Orcamento extends EntityObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;

	private Date data;

	private List<ProdutoVenda> produtos;
	
	public Orcamento(){
		
	}

	public Orcamento(Cliente cliente, Date data, List<ProdutoVenda> produtos) {
		super();
		this.cliente = cliente;
		this.data = data;
		this.produtos = produtos;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public List<ProdutoVenda> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoVenda> produtos) {
		this.produtos = produtos;
	}	
	
}