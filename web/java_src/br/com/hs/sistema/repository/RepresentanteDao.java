package br.com.hs.sistema.repository;

import br.com.hs.model.entity.Representante;

public interface RepresentanteDao extends GenericRepositoryDao<Representante>{
	Representante login(String usuario, String senha) throws Exception;
}
