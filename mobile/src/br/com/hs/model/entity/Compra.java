package br.com.hs.model.entity;

import java.util.List;

public class Compra extends EntityObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Fornecedor fornecedor;	

	private Funcionario funcionario;

	private List<MaterialCompra> materiais;	
	
	public Compra(){
		
	}
	
	public Compra(Fornecedor fornecedor, Funcionario funcionario, List<MaterialCompra> materiais) {
		super();
		this.fornecedor = fornecedor;		
		this.funcionario = funcionario;
		this.materiais = materiais;	
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
		
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public List<MaterialCompra> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<MaterialCompra> materiais) {
		this.materiais = materiais;
	}	
}