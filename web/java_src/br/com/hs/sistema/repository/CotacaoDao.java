package br.com.hs.sistema.repository;

import java.util.List;

import br.com.hs.model.entity.Cotacao;
import br.com.hs.model.entity.Material;

public interface CotacaoDao extends GenericRepositoryDao<Cotacao>{
	
	List<Cotacao> buscarTodosPorMaterial(Material material)throws Exception;
	
}
