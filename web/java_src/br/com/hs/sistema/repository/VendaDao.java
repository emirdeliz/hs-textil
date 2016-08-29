package br.com.hs.sistema.repository;

import java.util.Date;
import java.util.List;

import br.com.hs.model.entity.Caixa;
import br.com.hs.model.entity.Cliente;
import br.com.hs.model.entity.FormaPagamento;
import br.com.hs.model.entity.Produto;
import br.com.hs.model.entity.Representante;

public interface VendaDao extends GenericRepositoryDao<Caixa>{
	
	List<Caixa> geraRelatorio(Cliente cliente, Representante representante, FormaPagamento formaPagamento, Produto produto, Date dataI, Date dataF) throws Exception;

}
