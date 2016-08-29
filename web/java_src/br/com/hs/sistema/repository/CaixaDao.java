package br.com.hs.sistema.repository;

import java.util.Date;
import java.util.List;

import br.com.hs.model.entity.Caixa;

public interface CaixaDao extends GenericRepositoryDao<Caixa>{
	List<Caixa> filtroCaixa(Date dataI, Date dataF, Integer tipo)throws Exception;	
}
