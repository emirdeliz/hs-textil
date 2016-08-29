package br.com.hs.sistema.service;

import java.io.Serializable;
import java.util.List;

import br.com.hs.model.entity.TipoDespesa;

public interface TipoDespesaService {
	
	void deletar(final TipoDespesa entity)throws Exception;

	TipoDespesa salvar(TipoDespesa entity)throws Exception;

	TipoDespesa buscarPorId(Serializable oid)throws Exception;

	List<TipoDespesa> buscarTodos()throws Exception;
	
	List<TipoDespesa> buscarTodosAtivos()throws Exception;
}
