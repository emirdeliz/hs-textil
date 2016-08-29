package br.com.hs.sistema.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.hs.model.entity.Representante;
import br.com.hs.sistema.controller.logger;
import br.com.hs.sistema.repository.RepresentanteDao;
import br.com.hs.sistema.service.RepresentanteService;

@Service
@RemotingDestination(value="representanteService")
public class RepresentanteServiceImpl implements RepresentanteService{
	
	@Autowired	
	private RepresentanteDao repository;
		
	public Representante buscarPorId(Serializable oid)throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List entity Representante by id: " + oid);	
			return this.repository.buscarPorId(Representante.class, oid);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while querying data: " + e);
			throw e;
		}
	}
	
	public List<Representante> buscarTodos()throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List All entity: Representante");
			return this.repository.buscarTodos(Representante.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}
	}
	
	public void deletar(Representante entity)throws Exception {
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
	
	public Representante salvar(Representante entity)throws Exception {
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
	
	public Representante login(String usuario, String senha) throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("Find login");
			return repository.login(usuario, senha);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while login: " + e);
			throw e;
		}
	}
	
	@Override
	public List<Representante> buscarTodosAtivos() throws Exception {
		try {
			logger.info("List All ativos entity: Representante");
			return this.repository.buscarTodosAtivos(Representante.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}	
	}
	
}
