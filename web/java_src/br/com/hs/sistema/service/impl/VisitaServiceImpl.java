package br.com.hs.sistema.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.hs.model.entity.Representante;
import br.com.hs.model.entity.Visita;
import br.com.hs.sistema.controller.logger;
import br.com.hs.sistema.repository.VisitaDao;
import br.com.hs.sistema.service.VisitaService;

@Service
@RemotingDestination(value="visitaService")
public class VisitaServiceImpl implements VisitaService{
	
	@Autowired	
	private VisitaDao repository;
		
	public Visita buscarPorId(Serializable oid)throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List entity Visita by id: " + oid);	
			return this.repository.buscarPorId(Visita.class, oid);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while querying data: " + e);
			throw e;
		}
	}
	
	public List<Visita> buscarTodos()throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List All entity: Visita");
			return this.repository.buscarTodos(Visita.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}	
	}
	
	public void deletar(Visita entity)throws Exception {
		// TODO Auto-generated method stub	
		try {
			logger.info("Delete a new entity: " + entity);
			this.repository.deletar(entity);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while deleting item: " + e);
			throw e;
		}
	}
	
	public Visita salvar(Visita entity)throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("Save a new entity: " + entity);
			return entity.getOid()>0?repository.atualizar(entity):repository.salvar(entity);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while: " +(entity.getOid()>0? "updating":"saving")+" item: " + e);
			throw e;
		}			 
	}
	
	public List<Visita> buscarTodosPorRepresentante(Date dataAgenda, Representante representante, Boolean inativo) throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("Find visita by representante: " + dataAgenda);
			return repository.buscarTodosPorRepresentante(dataAgenda, representante, inativo);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while: find visitas by representante item: " + e);
			throw e;
		}	
	}

	public List<Visita> buscarTodosPorData(Date dataI, Date dataF, Boolean inativo)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("Find visita by data inicio: " + dataI + " data final: " + dataF);
			return repository.buscarTodosPorData(dataI, dataF, inativo);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while: find visitas by date: " + e);
			throw e;
		}	
	}	
}
