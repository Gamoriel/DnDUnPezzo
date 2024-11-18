package org.prepuzy.dao.JPA;

import org.prepuzy.dao.DaoInventario;
import org.prepuzy.model.Inventario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

public class JpaDaoInventario implements DaoInventario {
    private static JpaDaoInventario instance;

    public static JpaDaoInventario getInstance() {
	if (instance == null) {
	    instance = new JpaDaoInventario();
	}
	return instance;
    }

    @Override
    public Inventario selectById(long id) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    return em.find(Inventario.class, id);
	}  catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}
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
    public boolean delete(long id) {

	return false;
    }

    @Override
    public Inventario selectByPersonaggioId(long id) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    return em
		    .createQuery("SELECT i FROM Inventario i WHERE i.personaggio.id = :personaggioId", Inventario.class)
		    .setParameter("personaggioId", id).getSingleResult();
	} catch (NoResultException e) {
	    return null;
	} finally {
	    em.close();
	}
    }

    @Override
    public Inventario selectByNaveId(long id) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    return em.createQuery("SELECT i FROM Inventario i WHERE i.nave.id = :naveId", Inventario.class)
		    .setParameter("naveId", id).getSingleResult();
	} catch (NoResultException e) {
	    return null;
	} finally {
	    em.close();
	}
    }
}
