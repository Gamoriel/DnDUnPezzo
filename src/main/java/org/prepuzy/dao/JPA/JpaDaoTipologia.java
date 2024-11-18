package org.prepuzy.dao.JPA;

import java.util.List;

import org.prepuzy.dao.DaoTipologia;
import org.prepuzy.model.Tipologia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class JpaDaoTipologia implements DaoTipologia {
    private static JpaDaoTipologia instance;

    public static JpaDaoTipologia getInstance() {
	if (instance == null) {
	    instance = new JpaDaoTipologia();
	}
	return instance;
    }

    @Override
    public Tipologia selectById(long id) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	Tipologia tipologia = null;
	try {
	    tipologia = em.find(Tipologia.class, id);
	} catch (NoResultException e) {
	    System.out.println("Nessuna tipologia trovata con ID: " + id);

	    System.err.println("Errore durante il recupero della tipologia: " + e.getMessage());
	} finally {
	    em.close();
	}
	return tipologia;
    }

    @Override
    public List<Tipologia> selectAll() {
	EntityManager em = JpaDaoFactory.getEntityManager();
	List<Tipologia> tipologie = null;
	try {
	    TypedQuery<Tipologia> query = em.createQuery("SELECT t FROM Tipologia t", Tipologia.class);
	    return (query.getResultList());
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    em.close();
	}
	return tipologie;
    }

    @Override
    public void update(Tipologia t) {

    }

    @Override
    public boolean delete(long id) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	EntityTransaction t = em.getTransaction();
	try {
	    t.begin();
	    Tipologia tipologia = em.find(Tipologia.class, id);
	    if (tipologia != null) {
		em.remove(tipologia);
		t.commit();
		return true;
	    } else {
		t.rollback();
	    }
	} catch (Exception e) {
	    if (t != null && t.isActive()) {
		t.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    em.close();
	}
	return false;
    }

    @Override
    public void insert(Tipologia ti) {
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
