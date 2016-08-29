package br.com.hs.sistema.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import br.com.hs.sistema.repository.GenericRepositoryDao;


@Repository
public class GenericRepositoryDaoImpl<E> extends HibernateDaoSupport implements GenericRepositoryDao<E> {

	@Autowired
	public void init(final SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public List<E> buscarTodos(final Class<E> clazz)throws Exception {
		logger.info("Find all: " + clazz.getName());
		return getHibernateTemplate().loadAll(clazz);
	}
	
	@SuppressWarnings("unchecked")
	public List<E> buscarTodosAtivos(final Class<E> clazz)throws Exception {
		logger.info("Find all actives: " + clazz.getName());
		Criteria criteria = this.getSession().createCriteria(clazz);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);		
		criteria.add(Restrictions.eq("inativo", false));	
		return criteria.list();
	}

	public void deletar(final E entity)throws Exception {
		logger.info("Delete row: " + entity);
		getHibernateTemplate().delete(entity);
		getHibernateTemplate().flush();
	}

	public E salvar(final E entity)throws Exception {		
		logger.info("Save new row: " + entity);
		getHibernateTemplate().persist(entity);
		getHibernateTemplate().flush();
		return entity;
	}
	
	public E buscarPorId(final Class<E> clazz, final Serializable oid) {
		logger.info("Find: " + clazz.getClass() +" by oid: " + oid);
		return getHibernateTemplate().get(clazz, oid);
	}

	public E atualizar(final E entity)throws Exception {
		logger.info("Update row: " + entity );
		getHibernateTemplate().merge(entity);
		getHibernateTemplate().flush();
		return entity;
	}
	/*
	public void merge(final E entity)throws Exception {
		getHibernateTemplate().merge(entity);
		getHibernateTemplate().flush();
	}
	@SuppressWarnings("unchecked")
	public List<E> buscar(final String query, final Object[] param) {
		return getHibernateTemplate().find(query, param);
	}
	
	public int execute(String query) {
		Query q = this.getSession().createQuery(query);
		int ret = q.executeUpdate();
		getHibernateTemplate().flush();
		return ret;
	}
	*/
}
