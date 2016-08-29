package br.com.hs.sistema.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.hs.model.entity.Caixa;
import br.com.hs.model.entity.Cliente;
import br.com.hs.model.entity.FormaPagamento;
import br.com.hs.model.entity.Produto;
import br.com.hs.model.entity.Representante;

public interface VendaService {
	
	void deletar(final Caixa entity)throws Exception;

	Caixa salvar(Caixa entity)throws Exception;

	Caixa buscarPorId(Serializable oid)throws Exception;

	List<Caixa> buscarTodos()throws Exception;
	
	List<Caixa> geraRelatorio(Cliente cliente, Representante representante, FormaPagamento formaPagamento, Produto produto, Date dataI, Date dataF)throws Exception;
}
