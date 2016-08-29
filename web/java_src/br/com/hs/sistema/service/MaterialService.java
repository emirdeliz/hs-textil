package br.com.hs.sistema.service;

import java.io.Serializable;
import java.util.List;

import br.com.hs.model.entity.Material;

public interface MaterialService {
	
	void deletar(final Material entity)throws Exception;

	Material salvar(Material entity)throws Exception;

	Material buscarPorId(Serializable oid)throws Exception;

	List<Material> buscarTodos()throws Exception;	
	
	List<Material> buscarTodosAtivos()throws Exception;	
}
