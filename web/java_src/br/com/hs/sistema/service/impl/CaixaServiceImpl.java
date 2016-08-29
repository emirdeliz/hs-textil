package br.com.hs.sistema.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.hs.model.entity.Caixa;
import br.com.hs.sistema.controller.logger;
import br.com.hs.sistema.repository.CaixaDao;
import br.com.hs.sistema.service.CaixaService;

@Service
@RemotingDestination(value="caixaService")
public class CaixaServiceImpl implements CaixaService{
	@Autowired	
	private CaixaDao repository;
			
	public Caixa buscarPorId(Serializable oid)throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List entity Caixa by id: " + oid);	
			return this.repository.buscarPorId(Caixa.class, oid);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while querying data: " + e);
			throw e;
		}
	}
	
	public List<Caixa> buscarTodos() throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List All entity: Cargo");
			return this.repository.buscarTodos(Caixa.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}	
	}	
	
	public void deletar(Caixa entity)throws Exception {
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
	
	public Caixa salvar(Caixa entity)throws Exception {
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
	
	public List<Caixa> filtroCaixa(Date dataI, Date dataF, Integer tipo)throws Exception {
		try {
			logger.info("Filter caixa...");
			return repository.filtroCaixa(dataI, dataF, tipo);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while filter caixa: " + e);
			throw e;
		}
	}
}
