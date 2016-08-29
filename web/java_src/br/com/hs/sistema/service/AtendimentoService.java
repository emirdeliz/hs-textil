package br.com.hs.sistema.service;

import java.io.Serializable;
import java.util.List;

import br.com.hs.model.entity.Atendimento;

public interface AtendimentoService {
	
	void deletar(final Atendimento entity) throws Exception;

	Atendimento salvar(Atendimento entity) throws Exception;

	Atendimento buscarPorId(Serializable oid) throws Exception;

	List<Atendimento> buscarTodos() throws Exception;

}
