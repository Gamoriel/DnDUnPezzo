package org.prepuzy.dao.JPA;

import java.util.List;

import org.prepuzy.dao.DaoRazza;
import org.prepuzy.model.Oggetto;
import org.prepuzy.model.Personaggio;
import org.prepuzy.model.Razza;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class JpaDaoRazza implements DaoRazza {
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
	    return (q.getResultList());
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
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
	    Razza r = em.find(Razza.class, id);
	    if (r != null) {
		for (Personaggio p : r.getPersonaggi()) {
		    p.setRazza(null);
		    em.merge(p);
		}
		for (Oggetto o : r.getOggetto()) {
		    o.setRazze(null);
		    em.merge(o);
		}
		em.remove(r);
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
