package br.com.hs.sistema.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.hs.model.entity.Representante;
import br.com.hs.model.entity.Visita;

public interface VisitaService {
	
	void deletar(final Visita entity)throws Exception;

	Visita salvar(Visita entity)throws Exception;

	Visita buscarPorId(Serializable oid)throws Exception;

	List<Visita> buscarTodos()throws Exception;
	
	List<Visita> buscarTodosPorData(Date dataI, Date dataF, Boolean inativo)throws Exception;
	
	List<Visita> buscarTodosPorRepresentante(Date dataAgenda, Representante representante, Boolean inativo)throws Exception;
}
