package br.com.hs.sistema.repository.impl;

import org.springframework.stereotype.Repository;

import br.com.hs.model.entity.Cliente;
import br.com.hs.sistema.repository.ClienteDao;

@Repository
public class ClienteDaoImpl extends GenericRepositoryDaoImpl<Cliente> implements ClienteDao{	
	
}
