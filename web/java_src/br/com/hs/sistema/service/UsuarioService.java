package br.com.hs.sistema.service;

public interface UsuarioService {
	Object autenticarFuncionario(String usuario, String senha) throws Exception;
	Object autenticarFornecedor(String usuario, String senha) throws Exception;
	Object autenticarRepresentante(String usuario, String senha) throws Exception;
	Boolean validaPermissaoUsuarioWS(String usuario, String senha) throws Exception;
}
