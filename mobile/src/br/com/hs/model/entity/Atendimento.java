package br.com.hs.model.entity;

import java.util.Date;

public class Atendimento extends EntityObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date data;
	
	private String descricao;
	
	public Atendimento(){
		
	}	
	
	public Atendimento(Date data, String descricao) {
		super();
		this.data = data;
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	
}