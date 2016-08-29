package br.com.hs.sistema.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.hs.model.entity.Caixa;
import br.com.hs.model.entity.TipoDespesa;

public interface DespesaService {
	
	void deletar(final Caixa entity)throws Exception;

	Caixa salvar(Caixa entity)throws Exception;

	Caixa buscarPorId(Serializable oid)throws Exception;

	List<Caixa> buscarTodos()throws Exception;
	
	List<Caixa> geraRelatorio(TipoDespesa tipoDespesa, Date dataI, Date dataF)throws Exception;

}
