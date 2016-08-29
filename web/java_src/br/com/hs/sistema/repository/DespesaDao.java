package br.com.hs.sistema.repository;

import java.util.Date;
import java.util.List;

import br.com.hs.model.entity.Caixa;
import br.com.hs.model.entity.TipoDespesa;

public interface DespesaDao extends GenericRepositoryDao<Caixa>{
	
	public List<Caixa> geraRelatorio(TipoDespesa tipoDespesa, Date dataI,Date dataF) throws Exception;
	
}
