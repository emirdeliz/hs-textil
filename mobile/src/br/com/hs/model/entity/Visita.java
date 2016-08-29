package br.com.hs.model.entity;

import java.util.Date;

public class Visita extends EntityObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Atendimento atendimento;
	
	private Representante representante;
	
	private Date dataContato;
	
	private Date dataAgenda;
	
	private Cliente cliente;
	
	private String observacao;	
	
	private Date dataVisita;
	
	private Boolean inativo;
	
	public Visita(){
		
	}

	public Visita(Atendimento atendimento,
			Representante representante, Date dataContato, Date dataAgenda,
			Cliente cliente, String observacao, Date dataVisita) {
		super();		
		this.atendimento = atendimento;
		this.representante = representante;
		this.dataContato = dataContato;
		this.dataAgenda = dataAgenda;
		this.cliente = cliente;
		this.observacao = observacao;
		this.dataVisita = dataVisita;
	}
			
	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
		
	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	public Date getDataContato() {
		return dataContato;
	}

	public void setDataContato(Date dataContato) {
		this.dataContato = dataContato;
	}

	public Date getDataAgenda() {
		return dataAgenda;
	}

	public void setDataAgenda(Date dataAgenda) {
		this.dataAgenda = dataAgenda;
	}
		
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDataVisita() {
		return dataVisita;
	}

	public void setDataVisita(Date dataVisita) {
		this.dataVisita = dataVisita;
	}

	public Boolean getInativo() {
		return inativo;
	}

	public void setInativo(Boolean inativo) {
		this.inativo = inativo;
	}		
	
}