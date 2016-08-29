package br.com.hs.sistema.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.hs.model.entity.FormaPagamento;
import br.com.hs.sistema.controller.logger;
import br.com.hs.sistema.repository.FormaPagamentoDao;
import br.com.hs.sistema.service.FormaPagamentoService;

@Service
@RemotingDestination(value="formaPagamentoService")
public class FormaPagamentoServiceImpl implements FormaPagamentoService{
	
	@Autowired	
	private FormaPagamentoDao repository;
		
	public FormaPagamento buscarPorId(Serializable oid)throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List entity FormaPagamento by id: " + oid);	
			return this.repository.buscarPorId(FormaPagamento.class, oid);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while querying data: " + e);
			throw e;
		}
	}
	
	public List<FormaPagamento> buscarTodos()throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List All entity: FormaPagamento");
			return this.repository.buscarTodos(FormaPagamento.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}	
	}
	
	public void deletar(FormaPagamento entity)throws Exception {
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
	
	public FormaPagamento salvar(FormaPagamento entity)throws Exception {
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
	public List<FormaPagamento> buscarTodosAtivos() throws Exception {
		try {
			logger.info("List All ativos entity: FormaPagamento");
			return this.repository.buscarTodosAtivos(FormaPagamento.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}	
	}
	
}
