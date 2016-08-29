package br.com.hs.sistema.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.hs.model.entity.Caixa;
import br.com.hs.sistema.repository.CaixaDao;

@Repository
public class CaixaDaoImpl extends GenericRepositoryDaoImpl<Caixa> implements CaixaDao{

	@SuppressWarnings("unchecked")
	public List<Caixa> filtroCaixa(Date dataI, Date dataF, Integer tipo)throws Exception {
		// TODO Auto-generated method stub
		logger.info("Filter caixa with: Date I: "+dataI+" Date F: "+dataF+"Type: "+tipo);
		Criteria criteria = this.getSession().createCriteria(Caixa.class);
		
		if(dataI!=null)
			criteria.add(Restrictions.ge("dataVencimento", dataI));
		if(dataF!=null)
			criteria.add(Restrictions.le("dataVencimento", dataF));		
		if(tipo!=null)
			criteria.add(Restrictions.eq("tipo", tipo));
		
		return criteria.list();
	}
}
