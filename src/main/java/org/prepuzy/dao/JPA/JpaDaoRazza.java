package org.prepuzy.dao.JPA;


import java.util.List;

import org.prepuzy.dao.DaoRazza;
import org.prepuzy.model.Razza;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class JpaDaoRazza implements DaoRazza{
	private static JpaDaoRazza instance;
	
	public static JpaDaoRazza getInstance() {
		if (instance == null) {
			instance = new JpaDaoRazza();
		}
		return instance;
	}

	@Override
	public List<Razza> selectAll() {
		EntityManager em = JpaDaoFactory.getEntityManager();
		try {
			TypedQuery<Razza> q = em.createQuery("select r from Razza r", Razza.class);
			return(q.getResultList());
		} finally {
			em.close();
		}
	}

	@Override
	public Razza selectById(long id) {
        EntityManager em = JpaDaoFactory.getEntityManager();
        try {
            Razza razza = em.find(Razza.class, id);
            return razza;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
	}

	@Override
	public void update(Razza r) {
        EntityManager em = JpaDaoFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(r);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
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
			Razza professione = em.find(Razza.class, id);
			if (professione != null) {
				em.remove(professione);
				t.commit();
				return true;
			} else {
				return false;
			}
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
			throw e;
		} finally {
			em.close();
		}
	}

	@Override
	public void insert(Razza r) {
        EntityManager em = JpaDaoFactory.getEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            em.persist(r);
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
