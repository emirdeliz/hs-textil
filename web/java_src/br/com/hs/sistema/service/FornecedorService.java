package br.com.hs.sistema.service;

import java.io.Serializable;
import java.util.List;

import br.com.hs.model.entity.Fornecedor;
import br.com.hs.model.entity.Material;

public interface FornecedorService {
	
	void deletar(final Fornecedor entity)throws Exception;

	Fornecedor salvar(Fornecedor entity)throws Exception;

	Fornecedor buscarPorId(Serializable oid)throws Exception;
	
	List<Fornecedor> buscarPorMaterial(Material material)throws Exception;

	List<Fornecedor> buscarTodos()throws Exception;
	
	Fornecedor login(String usuario, String senha) throws Exception;
	
	List<Fornecedor> buscarTodosAtivos()throws Exception;
}
