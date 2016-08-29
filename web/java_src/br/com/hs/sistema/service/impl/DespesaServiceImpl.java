package br.com.hs.sistema.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.hs.model.entity.Caixa;
import br.com.hs.model.entity.TipoDespesa;
import br.com.hs.sistema.controller.logger;
import br.com.hs.sistema.repository.DespesaDao;
import br.com.hs.sistema.service.DespesaService;

@Service
@RemotingDestination(value="despesaService")
public class DespesaServiceImpl implements DespesaService{
	
	@Autowired	
	private DespesaDao repository;	
				
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
	
	public List<Caixa> buscarTodos()throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List All entity: Caixa");
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
			logger.info((entity.getOid()>0? "updating":"saving"));
			return entity.getOid()>0?repository.atualizar(entity):repository.salvar(entity);
		}catch (Exception e) {
			// TODO: handle exception
			logger.info("An error occurred while: " + (entity.getOid()>0? "updating":"saving") + " item: " + e);
			throw e;
		}			 
	}
	
	public List<Caixa> geraRelatorio(TipoDespesa tipoDespesa, Date dataI, Date dataF) throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("Generate report depesa...");
			return repository.geraRelatorio(tipoDespesa, dataI, dataF);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while filter caixa: " + e);
			throw e;
		}
	}	
}
