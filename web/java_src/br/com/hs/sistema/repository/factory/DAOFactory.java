package br.com.hs.sistema.repository.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOFactory {
	private static EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("hsContext");
	}
	public static EntityManager getInstance() {
		return emf.createEntityManager();
	}
}
