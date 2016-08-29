package br.com.hs.sistema.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.hs.model.entity.Caixa;
import br.com.hs.model.entity.FormaPagamento;
import br.com.hs.model.entity.Fornecedor;
import br.com.hs.model.entity.Funcionario;
import br.com.hs.sistema.repository.CompraDao;

@Repository
public class CompraDaoImpl extends GenericRepositoryDaoImpl<Caixa> implements CompraDao{	
	@SuppressWarnings("unchecked")
	public List<Caixa> buscarTodos(final Class<Caixa> clazz)throws Exception {
		logger.info("Find all: Caixa by Compra");
		Criteria criteria = this.getSession().createCriteria(Caixa.class);
		criteria.add(Restrictions.isNotNull("compra.oid"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")	
	public List<Caixa> geraRelatorio(Fornecedor fornecedor, Funcionario funcionario, FormaPagamento formaPagamento, Date dataI, Date dataF) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Generate report caixa with: fornecedor: "+fornecedor+" Funcionario: "+
				funcionario+" FormaPagamento: "+formaPagamento+" Date I: "+dataI+" Date F: "+dataF);
		
		Criteria criteria = this.getSession().createCriteria(Caixa.class);
		criteria.add(Restrictions.isNotNull("compra.oid"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);		
		
		if(fornecedor!=null){
			criteria.createCriteria("compra.fornecedor", Criteria.INNER_JOIN)
			.add(Restrictions.eq("oid", fornecedor.getOid()));
		}		
		if(funcionario!=null){
			criteria.createCriteria("compra.funcionario", Criteria.INNER_JOIN)
			.add(Restrictions.eq("oid", funcionario.getOid()));			
		}		
		if(formaPagamento!=null){
			criteria.add(Restrictions.eq("formaPagamento.oid", formaPagamento.getOid()));			
		}		
		if(dataI!=null){
			criteria.add(Restrictions.ge("dataCaixa", dataI));
		}
		if(dataF!=null){
			criteria.add(Restrictions.le("dataCaixa", dataF));	
		}
		return criteria.list();
	}
}
