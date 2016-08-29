package br.com.hs.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.IndexColumn;

@Entity
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

	@ManyToOne
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	@OneToOne
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	@ManyToMany(fetch=FetchType.EAGER)
	@Cascade(value=CascadeType.ALL)
	@IndexColumn(name="index_material")
	public List<MaterialCompra> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<MaterialCompra> materiais) {
		this.materiais = materiais;
	}	
}