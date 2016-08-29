package br.com.hs.sistema.service;

import java.io.Serializable;
import java.util.List;

import br.com.hs.model.entity.Representante;

public interface RepresentanteService {
	
	void deletar(final Representante entity)throws Exception;

	Representante salvar(Representante entity)throws Exception;

	Representante buscarPorId(Serializable oid)throws Exception;

	List<Representante> buscarTodos()throws Exception;
	
	Representante login(String usuario, String senha) throws Exception;
	
	List<Representante> buscarTodosAtivos()throws Exception;
}
