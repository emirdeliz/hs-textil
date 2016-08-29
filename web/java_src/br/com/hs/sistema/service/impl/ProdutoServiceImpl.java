package br.com.hs.sistema.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.hs.model.entity.Produto;
import br.com.hs.sistema.controller.logger;
import br.com.hs.sistema.repository.ProdutoDao;
import br.com.hs.sistema.service.ProdutoService;

@Service
@RemotingDestination(value="produtoService")
public class ProdutoServiceImpl implements ProdutoService{
	
	@Autowired	
	private ProdutoDao repository;
		
	public Produto buscarPorId(Serializable oid)throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List entity Produto by id: " + oid);	
			return this.repository.buscarPorId(Produto.class, oid);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while querying data: " + e);
			throw e;
		}
	}
	
	public List<Produto> buscarTodos()throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List All entity: Produto");
			return this.repository.buscarTodos(Produto.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}
	}
	
	public List<Produto> geraRelatorio(Produto produto, Date dataI, Date dataF) throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("Generate report produto...");
			return repository.geraRelatorio(produto, dataI, dataF);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while filter caixa: " + e);
			throw e;
		}
	}
	
	public void deletar(Produto entity)throws Exception {
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
	
	public Produto salvar(Produto entity)throws Exception {
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
	public List<Produto> buscarTodosAtivos() throws Exception {
		try {
			logger.info("List All ativos entity: Produto");
			return this.repository.buscarTodosAtivos(Produto.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}	
	}
	
}
