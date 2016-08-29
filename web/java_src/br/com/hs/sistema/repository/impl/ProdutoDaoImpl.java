package br.com.hs.sistema.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.hs.model.entity.Produto;
import br.com.hs.sistema.repository.ProdutoDao;

@Repository
public class ProdutoDaoImpl extends GenericRepositoryDaoImpl<Produto> implements ProdutoDao{

	@SuppressWarnings("unchecked")	
	public List<Produto> geraRelatorio(Produto produto, Date dataI, Date dataF)	throws Exception {
		// TODO Auto-generated method stub
		logger.info("Generate report produto with: produto: "+produto+" Date I: "+dataI+" Date F: "+dataF);
		
		Criteria criteria = this.getSession().createCriteria(Produto.class);		
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);			
		
		if(produto!=null){
			criteria.add(Restrictions.eq("oid", produto.getOid()));
		}		
		if(dataI!=null){
			criteria.add(Restrictions.ge("ultimaVenda", dataI));
		}
		if(dataF!=null){
			criteria.add(Restrictions.le("ultimaVenda", dataF));	
		}
		return criteria.list();
	}	
	
}
