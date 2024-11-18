package org.prepuzy.dao.JPA;

import java.util.List;

import org.prepuzy.dao.DaoMappa;
import org.prepuzy.model.Capitolo;
import org.prepuzy.model.Mappa;
import org.prepuzy.model.Personaggio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class JpaDaoMappa implements DaoMappa {
    private static JpaDaoMappa instance;

    public static JpaDaoMappa getInstance() {
	if (instance == null) {
	    instance = new JpaDaoMappa();
	}
	return instance;
    }

    @Override
    public Mappa selectById(long id) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    return (Mappa) em.createQuery("SELECT m FROM Mappa m WHERE m.id = :id", Mappa.class).setParameter("id", id)
		    .getSingleResult();
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}
    }

    @Override
    public List<Mappa> listaMappe() {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    TypedQuery<Mappa> q = em.createQuery("select m from Mappa m", Mappa.class);
	    return (q.getResultList());
	} finally {
	    em.close();
	}

    }

    @Override
    public void update(Mappa m) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	EntityTransaction t = em.getTransaction();
	try {
	    t.begin();
	    em.merge(m);
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
    public void delete(long id) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	EntityTransaction t = em.getTransaction();
	t.begin();
	try {
	    Mappa mappa = em.find(Mappa.class, id);
	    if (mappa != null) {
		if(mappa.getCapitolo() != null) {
		    Capitolo c = mappa.getCapitolo();
		    c.setMappa(null);
		}
		if(mappa.getPersonaggi() != null) {
		    List<Personaggio> p = mappa.getPersonaggi();
		    for(Personaggio personaggio : p) {
			personaggio.setMappe(null);
		    }
		}
		mappa.setCapitolo(null);
		mappa.setPersonaggi(null);
		em.remove(mappa);
	    }
	    t.commit();
	} catch (Exception e) {
	    t.rollback();
	    throw e;
	} finally {
	    em.close();
	}

    }

    @Override
    public void insert(Mappa m) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	EntityTransaction t = em.getTransaction();

	try {
	    t.begin();
	    em.persist(m);
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
    public List<Mappa> filtroSelectAll() {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    TypedQuery<Mappa> q = em.createQuery("select m from Mappa m where m.isVisibleToAll = true", Mappa.class);
	    return (q.getResultList());
	} finally {
	    em.close();
	}

    }
}
