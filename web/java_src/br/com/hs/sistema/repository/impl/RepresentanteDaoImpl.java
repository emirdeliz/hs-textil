package br.com.hs.sistema.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.hs.model.entity.Representante;
import br.com.hs.sistema.repository.RepresentanteDao;

@Repository
public class RepresentanteDaoImpl extends GenericRepositoryDaoImpl<Representante> implements RepresentanteDao{
	
	@SuppressWarnings("unchecked")
	public Representante login(String usuario, String senha) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Find login");
		Criteria criteria = this.getSession().createCriteria(Representante.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		criteria.add(Restrictions.eq("senha", senha));
		criteria.add(Restrictions.eq("inativo", false));
		List<Representante> list = criteria.list();
		return (Representante) (list.size()>0?list.get(0):null);
	}	
	
}
