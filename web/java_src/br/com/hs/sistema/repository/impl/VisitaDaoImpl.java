package br.com.hs.sistema.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.hs.model.entity.Representante;
import br.com.hs.model.entity.Visita;
import br.com.hs.sistema.repository.VisitaDao;

@Repository
public class VisitaDaoImpl extends GenericRepositoryDaoImpl<Visita> implements VisitaDao{
		
	@SuppressWarnings("unchecked")
	public List<Visita> buscarTodosPorRepresentante(Date dataAgenda, Representante representante, Boolean inativo) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Find all visitas by date: " + dataAgenda);				
		Criteria criteria = this.getSession().createCriteria(Visita.class);					
		criteria.add(Restrictions.eq("dataAgenda", dataAgenda));
		criteria.add(Restrictions.eq("representante.oid", representante.getOid()));
		criteria.add(Restrictions.eq("inativo", inativo));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Visita> buscarTodosPorData(Date dataI, Date dataF, Boolean inativo)throws Exception {
		// TODO Auto-generated method stub
		logger.info("Filter agenda with: Date I: "+dataI+" Date F: "+dataF);
		Criteria criteria = this.getSession().createCriteria(Visita.class);
		
		if(dataI!=null)
			criteria.add(Restrictions.ge("dataAgenda", dataI));
		if(dataF!=null)
			criteria.add(Restrictions.le("dataAgenda", dataF));				
		
		criteria.add(Restrictions.eq("inativo", inativo));
		return criteria.list();
	}	
	
}
