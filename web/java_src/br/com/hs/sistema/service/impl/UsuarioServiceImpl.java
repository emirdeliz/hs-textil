package br.com.hs.sistema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.hs.model.entity.Fornecedor;
import br.com.hs.model.entity.Funcionario;
import br.com.hs.model.entity.Representante;
import br.com.hs.sistema.service.FornecedorService;
import br.com.hs.sistema.service.FuncionarioService;
import br.com.hs.sistema.service.RepresentanteService;
import br.com.hs.sistema.service.UsuarioService;

@Service
@RemotingDestination(value = "usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private RepresentanteService representanteService;
	
	@Autowired
	private FornecedorService fornecedorService;

	public Object autenticarFuncionario(String usuario, String senha) throws Exception {
		Representante r = this.representanteService.login(usuario, senha);
		Funcionario f = this.funcionarioService.login(usuario, senha);			
		return r != null ? r : f;
	}

	public Object autenticarFornecedor(String usuario, String senha)throws Exception {
		// TODO Auto-generated method stub
		Fornecedor f = this.fornecedorService.login(usuario, senha);	
		return f;
	}
	
	public Object autenticarRepresentante(String usuario, String senha)throws Exception {
		// TODO Auto-generated method stub
		return  this.representanteService.login(usuario, senha);
	}
	
	public Boolean validaPermissaoUsuarioWS(String usuario, String senha)throws Exception {
		// TODO Auto-generated method stub		
		Representante representante = (Representante) this.autenticarRepresentante(usuario, senha);		
		Boolean usuarioAutenticado = (representante!=null);				
		return usuarioAutenticado;
	}

}
