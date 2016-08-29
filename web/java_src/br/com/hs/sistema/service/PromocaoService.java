package br.com.hs.sistema.service;

import java.io.Serializable;
import java.util.List;

import br.com.hs.model.entity.Promocao;

public interface PromocaoService {
	
	void deletar(final Promocao entity)throws Exception;

	Promocao salvar(Promocao entity)throws Exception;

	Promocao buscarPorId(Serializable oid)throws Exception;

	List<Promocao> buscarTodos()throws Exception;
}
