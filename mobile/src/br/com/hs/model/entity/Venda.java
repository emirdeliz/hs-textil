package br.com.hs.model.entity;

import java.util.List;

public class Venda extends EntityObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;

	private Representante representante;

	private List<ProdutoVenda> produtos;		
	
	private Atendimento atendimento;		
	
	public Venda(){
		
	}
	
	public Venda(Cliente cliente, Representante representante,
			List<ProdutoVenda> produtos, Atendimento atendimento) {
		super();
		this.cliente = cliente;
		this.representante = representante;
		this.produtos = produtos;
		this.atendimento = atendimento;			
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
		
	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}
		
	public List<ProdutoVenda> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoVenda> produtos) {
		this.produtos = produtos;
	}
	
	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}	
}