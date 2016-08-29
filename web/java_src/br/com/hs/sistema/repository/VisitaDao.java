package br.com.hs.sistema.repository;

import java.util.Date;
import java.util.List;

import br.com.hs.model.entity.Representante;
import br.com.hs.model.entity.Visita;

public interface VisitaDao extends GenericRepositoryDao<Visita>{
	
	List<Visita> buscarTodosPorRepresentante(Date dataAgendada, Representante representante, Boolean inativo)throws Exception;
	
	List<Visita> buscarTodosPorData(Date dataI, Date dataF, Boolean inativo)throws Exception;	
}
