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

	@ManyToOne
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@ManyToOne
	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}
	
	@ManyToMany(fetch=FetchType.EAGER)
	@Cascade(value=CascadeType.ALL)
	@IndexColumn(name="index_produto")
	public List<ProdutoVenda> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoVenda> produtos) {
		this.produtos = produtos;
	}
	
	@OneToOne	
	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}	
}