package org.prepuzy.dao.JPA;


import java.util.List;

import org.prepuzy.dao.DaoQualita;
import org.prepuzy.model.Frutto;
import org.prepuzy.model.Qualita;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class JpaDaoQualita implements DaoQualita{
	private static JpaDaoQualita instance;
	
	public static JpaDaoQualita getInstance() {
		if (instance == null) {
			instance = new JpaDaoQualita();
		}
		return instance;
	}

	@Override
	public List<Qualita> selectAll() {
		EntityManager em = JpaDaoFactory.getEntityManager();
        try {
            TypedQuery<Qualita> query = em.createQuery("SELECT q FROM Qualita q", Qualita.class);
            return(query.getResultList());
        } finally {
            em.close();
        }
	}

	@Override
	public Qualita selectById(long id) {
	    EntityManager em = JpaDaoFactory.getEntityManager();
	    try {
	        return em.find(Qualita.class, id);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	@Override
	public boolean delete(long id) {
		EntityManager em = JpaDaoFactory.getEntityManager();
	    EntityTransaction t = em.getTransaction();
	    try {
	        t.begin();
	        Qualita qualita = em.find(Qualita.class, id);
	        if (qualita != null) {
	            List<Frutto> fruttiAssociati = qualita.getFrutto();
	            if (fruttiAssociati != null) {
	                for (Frutto frutto : fruttiAssociati) {
	                    frutto.setQualita(null); 
	                    em.merge(frutto); 
	                }
	            }
	            em.remove(qualita);
	            t.commit();
	            return true;
	        } else {
	            t.rollback();
	            return false;
	        }
	    } catch (Exception e) {
	        if (t.isActive()) {
	            t.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	    return false;
	}

	@Override
	public void insert(Qualita q) {
        EntityManager em = JpaDaoFactory.getEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.persist(q);
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
