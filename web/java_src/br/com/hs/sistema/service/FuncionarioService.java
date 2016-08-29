package br.com.hs.sistema.service;

import java.io.Serializable;
import java.util.List;

import br.com.hs.model.entity.Funcionario;

public interface FuncionarioService {
	
	void deletar(final Funcionario entity)throws Exception;

	Funcionario salvar(Funcionario entity)throws Exception;

	Funcionario buscarPorId(Serializable oid)throws Exception;

	List<Funcionario> buscarTodos()throws Exception;
	
	Funcionario login(String usuario, String senha) throws Exception;
	
	List<Funcionario> buscarTodosAtivos()throws Exception;
}
