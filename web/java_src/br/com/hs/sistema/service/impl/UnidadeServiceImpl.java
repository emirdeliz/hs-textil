package br.com.hs.sistema.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.hs.model.entity.UnidadeMedida;
import br.com.hs.sistema.controller.logger;
import br.com.hs.sistema.repository.UnidadeDao;
import br.com.hs.sistema.service.UnidadeService;

@Service
@RemotingDestination(value="unidadeService")
public class UnidadeServiceImpl implements UnidadeService{
	
	@Autowired	
	private UnidadeDao repository;
		
	public UnidadeMedida buscarPorId(Serializable oid)throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List entity UnidadeMedida by id: " + oid);	
			return this.repository.buscarPorId(UnidadeMedida.class, oid);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while querying data: " + e);
			throw e;
		}
	}
	
	public List<UnidadeMedida> buscarTodos()throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List All entity: UnidadeMedida");
			return this.repository.buscarTodos(UnidadeMedida.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}	
	}
	
	public void deletar(UnidadeMedida entity)throws Exception {
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
	
	public UnidadeMedida salvar(UnidadeMedida entity)throws Exception {
		// TODO Auto-generated method stub
		try {			
			logger.info("Save a new entity: " + entity);
			logger.info((entity.getOid()>0? "updating -->":"saving -->"));
			return entity.getOid()>0?repository.atualizar(entity):repository.salvar(entity);
		}catch (Exception e) {
			// TODO: handle exception
			logger.info("An error occurred while: " + (entity.getOid()>0? "updating":"saving") + " item: " + e);
			throw e;
		}			 
	}	

}
