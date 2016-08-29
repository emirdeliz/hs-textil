package br.com.hs.sistema.service;

import java.io.Serializable;
import java.util.List;

import br.com.hs.model.entity.Cotacao;
import br.com.hs.model.entity.Material;

public interface CotacaoService {
	
	void deletar(final Cotacao entity)throws Exception;

	Cotacao salvar(Cotacao entity)throws Exception;

	Cotacao buscarPorId(Serializable oid)throws Exception;

	List<Cotacao> buscarTodos()throws Exception;
	
	List<Cotacao> buscarTodosPorMaterial(Material material)throws Exception;
}
