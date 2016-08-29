package br.com.hs.sistema.service;

import java.io.Serializable;
import java.util.List;

import br.com.hs.model.entity.Cliente;

public interface ClienteService {
	
	void deletar(final Cliente entity)throws Exception;

	Cliente salvar(Cliente entity)throws Exception;

	Cliente buscarPorId(Serializable oid)throws Exception;

	List<Cliente> buscarTodos()throws Exception;
	
	List<Cliente> buscarTodosAtivos()throws Exception;
}
