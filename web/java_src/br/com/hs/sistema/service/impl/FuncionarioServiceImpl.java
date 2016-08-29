package br.com.hs.sistema.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.hs.model.entity.Funcionario;
import br.com.hs.sistema.controller.logger;
import br.com.hs.sistema.repository.FuncionarioDao;
import br.com.hs.sistema.service.FuncionarioService;

@Service
@RemotingDestination(value="funcionarioService")
public class FuncionarioServiceImpl implements FuncionarioService{
	
	@Autowired	
	private FuncionarioDao repository;
		
	public Funcionario buscarPorId(Serializable oid)throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List entity Funcionario by id: " + oid);	
			return this.repository.buscarPorId(Funcionario.class, oid);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while querying data: " + e);
			throw e;
		}
	}
	
	public List<Funcionario> buscarTodos()throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List All entity: Funcionario");
			return this.repository.buscarTodos(Funcionario.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}
	}
	
	public void deletar(Funcionario entity)throws Exception {
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
	
	public Funcionario salvar(Funcionario entity)throws Exception {
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
	
	public Funcionario login(String usuario, String senha) throws Exception {
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
	public List<Funcionario> buscarTodosAtivos() throws Exception {
		try {
			logger.info("List All ativos entity: Funcionario");
			return this.repository.buscarTodosAtivos(Funcionario.class);	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}	
	}
	
}
