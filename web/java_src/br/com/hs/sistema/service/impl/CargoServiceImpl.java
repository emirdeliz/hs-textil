package br.com.hs.sistema.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.hs.model.entity.Cargo;
import br.com.hs.sistema.controller.logger;
import br.com.hs.sistema.repository.CargoDao;
import br.com.hs.sistema.service.CargoService;

@Service
@RemotingDestination(value="cargoService")
public class CargoServiceImpl implements CargoService{
	
	@Autowired	
	private CargoDao repository;
		
	public Cargo buscarPorId(Serializable oid)throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List entity Cargo by id: " + oid);	
			return this.repository.buscarPorId(Cargo.class, oid);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while querying data: " + e);
			throw e;
		}
	}
	
	public List<Cargo> buscarTodos()throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List All entity: Cargo");
			return this.repository.buscarTodos(Cargo.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}	
	}
	
	public void deletar(Cargo entity)throws Exception {
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
	
	public Cargo salvar(Cargo entity)throws Exception {
		// TODO Auto-generated method stub
		try {			
			logger.info("Save a new entity: " + entity);
			logger.info((entity.getOid()>0? "updating":"saving"));
			return entity.getOid()>0?repository.atualizar(entity):repository.salvar(entity);
		}catch (Exception e) {
			// TODO: handle exception
			logger.info("An error occurred while: " + (entity.getOid()>0? "updating":"saving") + " item: " + e);
			throw e;
		}			 
	}

	@Override
	public List<Cargo> buscarTodosAtivos() throws Exception {
		try {
			logger.info("List All ativos entity: Cargo");
			return this.repository.buscarTodosAtivos(Cargo.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}	
	}	

}
