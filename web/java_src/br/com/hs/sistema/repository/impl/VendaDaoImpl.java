package br.com.hs.sistema.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.hs.model.entity.Caixa;
import br.com.hs.model.entity.Cliente;
import br.com.hs.model.entity.FormaPagamento;
import br.com.hs.model.entity.Produto;
import br.com.hs.model.entity.Representante;
import br.com.hs.sistema.repository.VendaDao;

@Repository
public class VendaDaoImpl extends GenericRepositoryDaoImpl<Caixa> implements VendaDao{	
	@SuppressWarnings("unchecked")
	public List<Caixa> buscarTodos(final Class<Caixa> clazz)throws Exception {
		logger.info("Find all: Caixa by Venda");
		Criteria criteria = this.getSession().createCriteria(Caixa.class);
		criteria.add(Restrictions.isNotNull("venda.oid"));	
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")	
	public List<Caixa> geraRelatorio(Cliente cliente, Representante representante, FormaPagamento formaPagamento, Produto produto, Date dataI, Date dataF) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Generate report caixa with: cliente: "+cliente+" Representante: "+
				representante+" FormaPagamento: "+formaPagamento+" Date I: "+dataI+" Date F: "+dataF);
		
		Criteria criteria = this.getSession().createCriteria(Caixa.class);
		criteria.add(Restrictions.isNotNull("venda.oid"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);		
		
		if(cliente!=null){
			criteria.createCriteria("venda.cliente", Criteria.INNER_JOIN)
			.add(Restrictions.eq("oid", cliente.getOid()));
		}		
		if(representante!=null){
			criteria.createCriteria("venda.representante", Criteria.INNER_JOIN)
			.add(Restrictions.eq("oid", representante.getOid()));			
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
		if(produto!=null){			
			criteria.createCriteria("venda.produtos", Criteria.INNER_JOIN).createAlias("produto", "pv");	
			criteria.add(Restrictions.eq("pv.oid", produto.getOid()));
		}
		return criteria.list();
	}
}
