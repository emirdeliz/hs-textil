package br.com.hs.sistema.service;

import java.io.Serializable;
import java.util.List;

import br.com.hs.model.entity.AcessoSistema;

public interface AcessoSistemaService {
	
	void deletar(final AcessoSistema entity)throws Exception;

	AcessoSistema salvar(AcessoSistema entity)throws Exception;

	AcessoSistema buscarPorId(Serializable oid)throws Exception;

	List<AcessoSistema> buscarTodos()throws Exception;
}
