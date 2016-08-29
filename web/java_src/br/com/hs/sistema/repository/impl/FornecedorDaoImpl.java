package br.com.hs.sistema.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.hs.model.entity.Fornecedor;
import br.com.hs.model.entity.Material;
import br.com.hs.sistema.repository.FornecedorDao;

@Repository
public class FornecedorDaoImpl extends GenericRepositoryDaoImpl<Fornecedor> implements FornecedorDao{	
	
	@SuppressWarnings("unchecked")
	public Fornecedor login(String usuario, String senha) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Find login");
		Criteria criteria = this.getSession().createCriteria(Fornecedor.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		criteria.add(Restrictions.eq("senha", senha));
		List<Fornecedor> list = criteria.list();
		return (Fornecedor) (list.size()>0?list.get(0):null);
	}
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> buscarPorMaterial(Material material) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Filter fornecedor by material: " + material);
			
		Criteria criteria = this.getSession().createCriteria(Fornecedor.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)		
		.createCriteria("materiais", Criteria.LEFT_JOIN)
		.add(Restrictions.eq("oid", material.getOid()));		
		
		List<Fornecedor> list = criteria.list();		
		return list;
	}	
}
