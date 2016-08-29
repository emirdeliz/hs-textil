package br.com.hs.sistema.repository;

import java.util.List;

import br.com.hs.model.entity.Fornecedor;
import br.com.hs.model.entity.Material;

public interface FornecedorDao extends GenericRepositoryDao<Fornecedor>{

	Fornecedor login(String usuario, String senha) throws Exception;
	
	List<Fornecedor> buscarPorMaterial(Material material)throws Exception;
}
