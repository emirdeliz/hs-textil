package br.com.hs.sistema.repository;

import br.com.hs.model.entity.Funcionario;

public interface FuncionarioDao extends GenericRepositoryDao<Funcionario>{
	Funcionario login(String usuario, String senha) throws Exception;
}
