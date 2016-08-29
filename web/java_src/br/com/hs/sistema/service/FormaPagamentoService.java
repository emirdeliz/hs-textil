package br.com.hs.sistema.service;

import java.io.Serializable;
import java.util.List;

import br.com.hs.model.entity.FormaPagamento;

public interface FormaPagamentoService {
	
	void deletar(final FormaPagamento entity)throws Exception;

	FormaPagamento salvar(FormaPagamento entity)throws Exception;

	FormaPagamento buscarPorId(Serializable oid)throws Exception;

	List<FormaPagamento> buscarTodos()throws Exception;
	
	List<FormaPagamento> buscarTodosAtivos()throws Exception;
}
