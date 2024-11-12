package org.prepuzy.dao.JPA;

import org.prepuzy.dao.DaoInventario;
import org.prepuzy.model.Inventario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class JpaDaoInventario implements DaoInventario{
	private static JpaDaoInventario instance;
	
	public static JpaDaoInventario getInstance() {
		if (instance == null) {
			instance = new JpaDaoInventario();
		}
		return instance;
	}

	@Override
	public Inventario selectById(long id) {
		
		return null;
	}

	@Override
	public void insert(Inventario i) {
	    EntityManager em = JpaDaoFactory.getEntityManager();
	    EntityTransaction t = em.getTransaction();
	    try {
	        t.begin();
	        em.merge(i);
	        t.commit();
	    } catch (Exception e) {
	        if (t.isActive()) {
	            t.rollback();
	        }
	        throw e;
	    } finally {
	        em.close();
	    }
	}

	@Override
	public void update(Inventario i) {
		
		
	}

	@Override
	public boolean delete(long id) {
		
		return false;
	}
}
