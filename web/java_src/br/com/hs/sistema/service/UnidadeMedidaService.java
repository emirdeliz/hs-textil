package br.com.hs.sistema.service;

import java.io.Serializable;
import java.util.List;

import br.com.hs.model.entity.UnidadeMedida;

public interface UnidadeMedidaService {
	
	void deletar(final UnidadeMedida entity)throws Exception;

	UnidadeMedida salvar(UnidadeMedida entity)throws Exception;

	UnidadeMedida buscarPorId(Serializable oid)throws Exception;

	List<UnidadeMedida> buscarTodos()throws Exception;
	
	List<UnidadeMedida> buscarTodosAtivos()throws Exception;
}
