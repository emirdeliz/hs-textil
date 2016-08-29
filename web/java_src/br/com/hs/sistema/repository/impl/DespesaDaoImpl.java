package br.com.hs.sistema.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.hs.model.entity.Caixa;
import br.com.hs.model.entity.TipoDespesa;
import br.com.hs.sistema.repository.DespesaDao;

@Repository
public class DespesaDaoImpl extends GenericRepositoryDaoImpl<Caixa> implements DespesaDao{	
	
	@SuppressWarnings("unchecked")
	public List<Caixa> buscarTodos(final Class<Caixa> clazz)throws Exception {
		logger.info("Find all: Caixa by Despesa");
		Criteria criteria = this.getSession().createCriteria(Caixa.class);
		criteria.add(Restrictions.isNotNull("despesa.oid"));		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Caixa> geraRelatorio(TipoDespesa tipoDespesa, Date dataI,Date dataF) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Generate report despesa with: cliente: " + tipoDespesa + "Date I: "+dataI+" Date F: "+dataF);
		Criteria criteria = this.getSession().createCriteria(Caixa.class);
		criteria.add(Restrictions.isNotNull("despesa.oid"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		if(tipoDespesa!=null){
			criteria.createCriteria("despesa", Criteria.INNER_JOIN).createAlias("tipoDespesa", "tp");		
			criteria.add(Restrictions.eq("tp.oid", tipoDespesa.getOid()));
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
