package br.com.hs.sistema.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.hs.model.entity.Fornecedor;
import br.com.hs.model.entity.Material;
import br.com.hs.sistema.controller.logger;
import br.com.hs.sistema.repository.FornecedorDao;
import br.com.hs.sistema.service.FornecedorService;

@Service
@RemotingDestination(value="fornecedorService")
public class FornecedorServiceImpl implements FornecedorService{
	
	@Autowired	
	private FornecedorDao repository;
		
	public Fornecedor buscarPorId(Serializable oid)throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List entity Fornecedor by id: " + oid);	
			return this.repository.buscarPorId(Fornecedor.class, oid);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while querying data: " + e);
			throw e;
		}
	}
	
	public List<Fornecedor> buscarTodos()throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List All entity: Fornecedor");			
			return this.repository.buscarTodos(Fornecedor.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}
	}
	
	public void deletar(Fornecedor entity)throws Exception {
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
	
	public Fornecedor salvar(Fornecedor entity)throws Exception {
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
	public Fornecedor login(String usuario, String senha) throws Exception {
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
	public List<Fornecedor> buscarPorMaterial(Material material) throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List All entity: Fornecedor by Material");			
			return this.repository.buscarPorMaterial(material);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}		
	}
	
	@Override
	public List<Fornecedor> buscarTodosAtivos() throws Exception {
		try {
			logger.info("List All ativos entity: Fornecedor");
			return this.repository.buscarTodosAtivos(Fornecedor.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}	
	}	
}
