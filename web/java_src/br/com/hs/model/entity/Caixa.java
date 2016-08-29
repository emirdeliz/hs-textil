package br.com.hs.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Caixa extends EntityObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer tipo;
		
	private Float valor;
	
	private Date dataVencimento;
	
	private Date dataCaixa;
	
	private Boolean pagamentoEfetuado;
	
	private Venda venda;
	
	private Compra compra;
	
	private Despesa despesa;
	
	private FormaPagamento formaPagamento;
	
	private String observacao;
		
	public Caixa(){
		
	}

	public Caixa(int tipo, Float valor, Date dataVencimento, Date dataCaixa, Boolean pagamentoEfetuado, 
			Compra compra, Venda venda, FormaPagamento formaPagamento, Despesa despesa, String observacao) {
		super();
		this.tipo = tipo;		
		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.dataCaixa = dataCaixa;
		this.pagamentoEfetuado = pagamentoEfetuado;
		this.compra = compra;
		this.venda = venda;
		this.formaPagamento = formaPagamento;
		this.despesa = despesa;
		this.observacao = observacao;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataCaixa() {
		return dataCaixa;
	}

	public void setDataCaixa(Date dataCaixa) {
		this.dataCaixa = dataCaixa;
	}

	public Boolean getPagamentoEfetuado() {
		return pagamentoEfetuado;
	}

	public void setPagamentoEfetuado(Boolean pagamentoEfetuado) {
		this.pagamentoEfetuado = pagamentoEfetuado;
	}
	
	@OneToOne
	@Cascade(value=CascadeType.ALL)	
	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	@OneToOne
	@Cascade(value=CascadeType.ALL)	
	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}	
	
	@OneToOne
	@Cascade(value=CascadeType.ALL)
	public Despesa getDespesa() {
		return despesa;
	}
		
	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}

	@ManyToOne
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}		
}