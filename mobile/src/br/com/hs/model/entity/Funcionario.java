package br.com.hs.model.entity;

import java.util.Date;

public class Funcionario extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Cargo cargo;

	private Date dataAdmissao;

	private String usuario;

	private String senha;

	private AcessoSistema acessoSistema;		
	
	public Funcionario(){
		
	}
	
	public Funcionario(String id, String nome, String endereco, String contato,
			String email, Cargo cargo, Date dataAdmissao, String usuario,
			String senha, AcessoSistema acessoSistema, Boolean inativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
		this.email = email;
		this.cargo = cargo;
		this.dataAdmissao = dataAdmissao;
		this.usuario = usuario;
		this.senha = senha;
		this.acessoSistema = acessoSistema;
		this.inativo = inativo;
	}
	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
		
	public AcessoSistema getAcessoSistema() {
		return acessoSistema;
	}

	public void setAcessoSistema(AcessoSistema acessoSistema) {
		this.acessoSistema = acessoSistema;
	}	
	
}