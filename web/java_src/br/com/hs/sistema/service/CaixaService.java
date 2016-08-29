package br.com.hs.sistema.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.hs.model.entity.Caixa;

public interface CaixaService {
	
	void deletar(final Caixa entity)throws Exception;

	Caixa salvar(Caixa entity)throws Exception;

	Caixa buscarPorId(Serializable oid)throws Exception;

	List<Caixa> buscarTodos()throws Exception;
	
	List<Caixa> filtroCaixa(Date dataI, Date dataF, Integer tipo)throws Exception;
		
}
