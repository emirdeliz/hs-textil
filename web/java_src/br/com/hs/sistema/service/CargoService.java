package br.com.hs.sistema.service;

import java.io.Serializable;
import java.util.List;

import br.com.hs.model.entity.Cargo;

public interface CargoService {
	
	void deletar(final Cargo entity)throws Exception;

	Cargo salvar(Cargo entity)throws Exception;

	Cargo buscarPorId(Serializable oid)throws Exception;

	List<Cargo> buscarTodos()throws Exception;
	
	List<Cargo> buscarTodosAtivos()throws Exception;
}
