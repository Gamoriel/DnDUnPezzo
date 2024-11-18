package org.prepuzy.dao.JPA;

import java.util.List;

import org.prepuzy.dao.DaoNave;
import org.prepuzy.model.Ciurma;
import org.prepuzy.model.Equipaggiamento;
import org.prepuzy.model.Inventario;
import org.prepuzy.model.Nave;
import org.prepuzy.model.Personaggio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class JpaDaoNave implements DaoNave {
    private static JpaDaoNave instance;

    public static JpaDaoNave getInstance() {
	if (instance == null) {
	    instance = new JpaDaoNave();
	}
	return instance;
    }

    @Override
    public List<Nave> selectAll() {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    TypedQuery<Nave> q = em.createQuery("select n from Nave n", Nave.class);
	    return (q.getResultList());
	} finally {
	    em.close();
	}

    }

    @Override
    public Nave selectById(long id) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    return em.find(Nave.class, id);
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}
    }

    @Override
    public void update(Nave n) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	EntityTransaction t = em.getTransaction();
	try {
	    t.begin();
	    em.merge(n);
	    t.commit();
	} catch (Exception e) {
	    if (t.isActive()) {
		t.rollback();
	    }
	    e.printStackTrace();
	    throw new RuntimeException("Errore durante l'aggiornamento della nave", e);
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
	    Nave nave = em.find(Nave.class, id);
	    if (nave != null) {
		for (Personaggio p : nave.getPersonaggi()) {
		    p.setNave(null);
		    em.merge(p);
		}
		if (nave.getEquip() != null) {
		Equipaggiamento equip = nave.getEquip();
		equip.setNave(null);
		}
		if (nave.getCiurma() != null) {
		Ciurma ciurma = nave.getCiurma();
		ciurma.setNave(null);
		}
		if (nave.getDeposito() != null) {
		Inventario inventario = nave.getDeposito();
		inventario.setNave(null);
		}
		nave.setCiurma(null);
		nave.setDeposito(null);
		nave.setEquip(null);
		em.remove(nave);
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
	    return false;
	} finally {
	    em.close();
	}
    }

    @Override
    public void insert(Nave n) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	EntityTransaction t = em.getTransaction();

	try {
	    t.begin();
	    Equipaggiamento e = new Equipaggiamento();
	    Inventario i = new Inventario();
	    e.setNave(n);
	    i.setNave(n);
	    n.setEquip(e);
	    n.setDeposito(i);
	    em.persist(e);
	    em.persist(i);
	    em.persist(n);
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
    public List<Nave> filtroSceletAll() {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    TypedQuery<Nave> q = em.createQuery("select n from Nave n where n.isVisibleToAll = true", Nave.class);
	    return (q.getResultList());
	} finally {
	    em.close();
	}

    }

}
