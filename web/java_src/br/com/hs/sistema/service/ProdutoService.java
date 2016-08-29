package br.com.hs.sistema.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.hs.model.entity.Produto;

public interface ProdutoService {
	
	void deletar(final Produto entity)throws Exception;

	Produto salvar(Produto entity)throws Exception;

	Produto buscarPorId(Serializable oid)throws Exception;

	List<Produto> buscarTodos()throws Exception;
	
	List<Produto> geraRelatorio(Produto produto, Date dataI, Date dataF)throws Exception;
	
	List<Produto> buscarTodosAtivos()throws Exception;
}
