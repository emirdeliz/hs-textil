package br.com.hs.sistema.service;

import java.io.Serializable;
import java.util.List;

import br.com.hs.model.entity.Orcamento;

public interface OrcamentoService {
	
	void deletar(final Orcamento entity)throws Exception;

	Orcamento salvar(Orcamento entity)throws Exception;

	Orcamento buscarPorId(Serializable oid)throws Exception;

	List<Orcamento> buscarTodos()throws Exception;
}
