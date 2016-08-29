package br.com.hs.sistema.repository;

import java.util.Date;
import java.util.List;

import br.com.hs.model.entity.Caixa;
import br.com.hs.model.entity.FormaPagamento;
import br.com.hs.model.entity.Fornecedor;
import br.com.hs.model.entity.Funcionario;


public interface CompraDao extends GenericRepositoryDao<Caixa>{
	
	List<Caixa> geraRelatorio(Fornecedor fornecedor, Funcionario funcionario, FormaPagamento formaPagamento, Date dataI, Date dataF) throws Exception;
}
