package br.com.hs.model.entity;


public class FluxoCaixa extends EntityObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Caixa caixa;
	
	private Fornecedor fornecedor;
	
	private Cliente cliente;
	
	public FluxoCaixa(Caixa caixa, Fornecedor fornecedor, Cliente cliente) {
		super();
		this.caixa = caixa;
		this.fornecedor = fornecedor;
		this.cliente = cliente;
	}
	
	public FluxoCaixa(){
		
	}
	
	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}
		
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
	
}
