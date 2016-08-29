package br.com.hs.model.entity;

import java.util.Date;
import java.util.List;

public class Representante extends Pessoa{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Cliente> clientes;
	
	private String usuario;

	private String senha;
	
	private Date dataAdmissao;

	private AcessoSistema acessoSistema;
	
	public Representante(){
		
	}
	
	public Representante(String id, String nome, String endereco, String contato,
			String email, String usuario, String senha, AcessoSistema acessoSistema, Date dataAdmissao, Boolean inativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
		this.email = email;		
		this.usuario = usuario;
		this.senha = senha;
		this.acessoSistema = acessoSistema;		
		this.dataAdmissao = dataAdmissao;
		this.inativo = inativo;
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
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}	

}
