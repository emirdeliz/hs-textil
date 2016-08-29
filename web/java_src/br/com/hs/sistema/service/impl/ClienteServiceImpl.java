package br.com.hs.sistema.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.hs.model.entity.Cliente;
import br.com.hs.sistema.controller.logger;
import br.com.hs.sistema.repository.ClienteDao;
import br.com.hs.sistema.service.ClienteService;

@Service
@RemotingDestination(value="clienteService")
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired	
	private ClienteDao repository;
	
	public Cliente buscarPorId(Serializable oid)throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List entity Cliente by id: " + oid);	
			return this.repository.buscarPorId(Cliente.class, oid);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while querying data: " + e);
			throw e;
		}
	}
	
	public List<Cliente> buscarTodos()throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List All entity: Material");
			return this.repository.buscarTodos(Cliente.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}	
	}
	
	public void deletar(Cliente entity)throws Exception {
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
	
	public Cliente salvar(Cliente entity)throws Exception {
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
	
	@Override
	public List<Cliente> buscarTodosAtivos() throws Exception {
		try {
			logger.info("List All ativos entity: Cliente");
			return this.repository.buscarTodosAtivos(Cliente.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}	
	}	

}
