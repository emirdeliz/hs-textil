package br.com.hs.sistema.repository;

import java.util.Date;
import java.util.List;

import br.com.hs.model.entity.Produto;

public interface ProdutoDao extends GenericRepositoryDao<Produto>{
	
	public List<Produto> geraRelatorio(Produto produto, Date dataI, Date dataF) throws Exception;
	
}
