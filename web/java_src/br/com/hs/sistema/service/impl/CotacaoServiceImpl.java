package br.com.hs.sistema.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.hs.model.entity.Cotacao;
import br.com.hs.model.entity.Material;
import br.com.hs.sistema.controller.logger;
import br.com.hs.sistema.repository.CotacaoDao;
import br.com.hs.sistema.service.CotacaoService;

@Service
@RemotingDestination(value="cotacaoService")
public class CotacaoServiceImpl implements CotacaoService{
	
	@Autowired	
	private CotacaoDao repository;
		
	public Cotacao buscarPorId(Serializable oid)throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List entity Cotacao by id: " + oid);	
			return this.repository.buscarPorId(Cotacao.class, oid);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while querying data: " + e);
			throw e;
		}
	}
	
	public List<Cotacao> buscarTodos()throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List All entity: Cotacao");
			return this.repository.buscarTodos(Cotacao.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}	
	}
	
	public void deletar(Cotacao entity)throws Exception {
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
	
	public Cotacao salvar(Cotacao entity)throws Exception {
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
	
	public List<Cotacao> buscarTodosPorMaterial(Material material) throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List all cotacao by material: " + material);
			return this.repository.buscarTodosPorMaterial(material);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}
	}	

}
