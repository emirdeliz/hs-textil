package br.com.hs.sistema.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.hs.model.entity.Cotacao;
import br.com.hs.model.entity.Material;
import br.com.hs.sistema.repository.CotacaoDao;

@Repository
public class CotacaoDaoImpl extends GenericRepositoryDaoImpl<Cotacao> implements CotacaoDao{
	
	@SuppressWarnings("unchecked")
	public List<Cotacao> buscarTodosPorMaterial(Material material) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Filter cotacao by material: " + material);
		
		Criteria criteria = this.getSession().createCriteria(Cotacao.class);		
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);		
		criteria.createCriteria("cotacoes", Criteria.INNER_JOIN).createAlias("material", "mc");		
		criteria.add(Restrictions.eq("mc.oid", material.getOid()));		
		return criteria.list();
	}	
	
}
