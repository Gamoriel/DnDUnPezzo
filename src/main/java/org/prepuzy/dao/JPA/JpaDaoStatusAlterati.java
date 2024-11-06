package org.prepuzy.dao.JPA;


import java.util.List;

import org.prepuzy.dao.DaoStatusAlterati;
import org.prepuzy.model.Oggetto;
import org.prepuzy.model.StatusAlterati;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class JpaDaoStatusAlterati implements DaoStatusAlterati{
	private static JpaDaoStatusAlterati instance;
	
	public static JpaDaoStatusAlterati getInstance() {
		if (instance == null) {
			instance = new JpaDaoStatusAlterati();
		}
		return instance;
	}

	@Override
	public List<StatusAlterati> selectAll() {
		EntityManager em = JpaDaoFactory.getEntityManager();
		try {
			TypedQuery<StatusAlterati> q = em.createQuery("select s from StatusAlterati s", StatusAlterati.class);
			return(q.getResultList());
		} finally {
			em.close();
		}

	}

	@Override
	public StatusAlterati selectById(long id) {
        EntityManager em = JpaDaoFactory.getEntityManager();
        StatusAlterati statusAlterato = null;

        try {
            statusAlterato = em.find(StatusAlterati.class, id);
        } finally {
            em.close();
        }
        return statusAlterato;
	}

	@Override
	public void update(StatusAlterati s) {
        EntityManager em = JpaDaoFactory.getEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            em.merge(s);
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

	@Override
	public boolean delete(long id) {
	    EntityManager em = JpaDaoFactory.getEntityManager();
	    EntityTransaction t = em.getTransaction();
	    try {
	        t.begin();
	        StatusAlterati status = em.find(StatusAlterati.class, id);
	        if (status != null) {
	            if (status.getOggetto() != null) {
	                for (Oggetto oggetto : status.getOggetto()) {
	                    oggetto.getStatus().remove(status);
	                    em.merge(oggetto);
	                }
	                status.getOggetto().clear();
	            }
	            em.remove(status);
	            t.commit();
	            return true;
	        } else {
	        	return false;
	        }
	    } catch (RuntimeException e) {
	        if (t.isActive()) {
	            t.rollback();
	        }
	        return false;
	    } finally {
	        em.close();
	    }
	}

	@Override
	public void insert(StatusAlterati s) {
        EntityManager em = JpaDaoFactory.getEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            em.persist(s);
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
