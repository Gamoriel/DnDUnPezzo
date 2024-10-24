package org.prepuzy.dao.JPA;


import java.util.List;

import org.prepuzy.dao.DaoTipo;
import org.prepuzy.model.Tipo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class JpaDaoTipo implements DaoTipo{
	private static JpaDaoTipo instance;
	
	public static JpaDaoTipo getInstance() {
		if (instance == null) {
			instance = new JpaDaoTipo();
		}
		return instance;
	}

	@Override
	public List<Tipo> selectAll() {
		EntityManager em = JpaDaoFactory.getEntityManager();
        try {
            TypedQuery<Tipo> query = em.createQuery("SELECT t FROM Tipo t", Tipo.class);
            return(query.getResultList());
        } finally {
            em.close();
        }
	}

	@Override
	public Tipo selectById(long id) {
	    EntityManager em = JpaDaoFactory.getEntityManager();
	    try {
	        return em.find(Tipo.class, id);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        em.close();
	    }
	}

	@Override
	public void update(Tipo t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(long id) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
	    try {
	        t.begin();
	        Tipo tipo = em.find(Tipo.class, id);
	        if (tipo != null) {
	            em.remove(tipo);
	            t.commit();
	            return true;
	        } else {
	        	return false;
	        }	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	    	em.close();
		}
	    return false;
	}

	@Override
	public void insert(Tipo ti) {
        EntityManager em = JpaDaoFactory.getEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            em.persist(ti);
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) {
                t.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close(); 
        }
	}
	
}
