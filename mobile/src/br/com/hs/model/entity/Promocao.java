package br.com.hs.model.entity;

import java.util.Date;

public class Promocao extends EntityObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date data;
	
	private Integer tipo;
	
	private String descricao;
	
	private Funcionario funcionario;
	
	public Promocao(){
		
	}

	public Promocao(Date data, Integer tipo, String descricao,
			Funcionario funcionario) {
		super();
		this.data = data;
		this.tipo = tipo;
		this.descricao = descricao;
		this.funcionario = funcionario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
		
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}	
	
}
