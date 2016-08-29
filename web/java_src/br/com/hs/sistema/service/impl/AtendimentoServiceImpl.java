package br.com.hs.sistema.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.hs.model.entity.Atendimento;
import br.com.hs.sistema.controller.logger;
import br.com.hs.sistema.repository.AtendimentoDao;
import br.com.hs.sistema.service.AtendimentoService;

@Service
@RemotingDestination(value="atendimentoService")
public class AtendimentoServiceImpl implements AtendimentoService{
	
	@Autowired	
	private AtendimentoDao repository;
		
	public Atendimento buscarPorId(Serializable oid) throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List entity Atendimento by id: " + oid);	
			return this.repository.buscarPorId(Atendimento.class, oid);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while querying data: " + e);
			throw e;
		}
		
	}
	
	public List<Atendimento> buscarTodos()throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List All entity: Atendimento");
			return this.repository.buscarTodos(Atendimento.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}
		
	}
	
	public void deletar(Atendimento entity)throws Exception {
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
	
	public Atendimento salvar(Atendimento entity)throws Exception {
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
}
