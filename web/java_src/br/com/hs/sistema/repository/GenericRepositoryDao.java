package br.com.hs.sistema.repository;

import java.io.Serializable;
import java.util.List;

public interface GenericRepositoryDao <E>{

	E atualizar(E entity) throws Exception;	

	void deletar(final E entity)throws Exception;

	E salvar(E entity)throws Exception;

	E buscarPorId(Class<E> clazz, Serializable oid)throws Exception;

	List<E> buscarTodos(final Class<E> clazz)throws Exception;
	
	List<E> buscarTodosAtivos(final Class<E> clazz)throws Exception;

	//List<E> buscar(String query, Object[] param);
	
	//void merge(final E entity)
	
	//int executa(String query);	
}
