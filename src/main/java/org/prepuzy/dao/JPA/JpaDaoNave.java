package org.prepuzy.dao.JPA;


import java.util.List;

import org.prepuzy.dao.DaoNave;
import org.prepuzy.model.Nave;

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
			return(q.getResultList());
		} finally {
			em.close();
		}

	}

	@Override
	public Nave selectById(long id) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			Nave nave = em.find(Nave.class, id);
			if (nave != null) {
				nave.getCiurma();
				nave.getDeposito();
				nave.getPersonaggi().size();
			}
			t.commit();
			return nave;
		} catch (Exception e) {
			if (t.isActive()) {
				t.rollback();
			}
			e.printStackTrace();
			return null;
		} finally {
			em.close();
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
			return(q.getResultList());
		} finally {
			em.close();
		}

	}

}
