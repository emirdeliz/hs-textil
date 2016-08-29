package br.com.hs.sistema.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.hs.model.entity.Funcionario;
import br.com.hs.sistema.repository.FuncionarioDao;

@Repository
public class FuncionarioDaoImpl extends GenericRepositoryDaoImpl<Funcionario> implements FuncionarioDao{	
	
	@SuppressWarnings("unchecked")
	public Funcionario login(String usuario, String senha) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Find login");	
		Criteria criteria = this.getSession().createCriteria(Funcionario.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		criteria.add(Restrictions.eq("senha", senha));
		criteria.add(Restrictions.eq("inativo", false));
		List<Funcionario> list = criteria.list();			
		return (Funcionario) (list.size()>0?list.get(0):null);
	}	
}
