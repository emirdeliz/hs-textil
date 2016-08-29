package br.com.hs.sistema.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.hs.model.entity.Material;
import br.com.hs.sistema.controller.logger;
import br.com.hs.sistema.repository.MaterialDao;
import br.com.hs.sistema.service.MaterialService;

@Service
@RemotingDestination(value="materialService")
public class MaterialServiceImpl implements MaterialService{
	
	@Autowired	
	private MaterialDao repository;
		
	public Material buscarPorId(Serializable oid)throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List entity Material by id: " + oid);	
			return this.repository.buscarPorId(Material.class, oid);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while querying data: " + e);
			throw e;
		}
	}
	
	public List<Material> buscarTodos()throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List All entity: Material");
			return this.repository.buscarTodos(Material.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}
	}
	
	public void deletar(Material entity)throws Exception {
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
	
	public Material salvar(Material entity)throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("Save a new entity: " + entity);
			if(entity.getQtdEstoque() < entity.getQtdMinimaEstoque()){
				
			}
			return entity.getOid()>0?repository.atualizar(entity):repository.salvar(entity);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while: " +(entity.getOid()>0? "updating":"saving")+" item: " + e);
			throw e;
		}		 
	}
	
	@Override
	public List<Material> buscarTodosAtivos() throws Exception {
		try {
			logger.info("List All ativos entity: Material");
			return this.repository.buscarTodosAtivos(Material.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}	
	}
	
}
