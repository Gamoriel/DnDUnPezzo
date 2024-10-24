package org.prepuzy.dao.JPA;



import java.util.List;

import org.prepuzy.dao.DaoCapitolo;
import org.prepuzy.model.Capitolo;
import org.prepuzy.model.Mappa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class JpaDaoCapitolo implements DaoCapitolo {
	private static JpaDaoCapitolo instance;

	public static JpaDaoCapitolo getInstance() {
		if (instance == null) {
			instance = new JpaDaoCapitolo();
		}
		return instance;
	}

	@Override
	public void insert(Capitolo c) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.merge(c);
		t.commit();
	}

	@Override
	public void update(Capitolo c) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.merge(c);
		t.commit();
	}

	@Override
	public List<Capitolo> selectAll() {
		EntityManager em = JpaDaoFactory.getEntityManager();
		TypedQuery<Capitolo> q = em.createQuery("select c from Capitolo c", Capitolo.class);
		return (q.getResultList());
	}

	@Override
	public Capitolo selectById(long id) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		String query = "SELECT c FROM Capitolo c JOIN FETCH c.mappa WHERE c.id = :id";
		return em.createQuery(query, Capitolo.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public List<Capitolo> SelectAllWithMappe() {
		EntityManager em = JpaDaoFactory.getEntityManager();
		TypedQuery<Capitolo> q = em.createQuery("select c from Capitolo c left join fetch c.mappa", Capitolo.class);
		return(q.getResultList());
	}

	@Override
	public boolean delete(long id) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();

		try {
			t.begin();
			Capitolo capitolo = em.find(Capitolo.class, id);
			if (capitolo != null) {
				em.remove(capitolo);
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
	public void updateConMappa(Capitolo c, Mappa m) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(c);
			em.merge(m);
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
	public List<Capitolo> filtroSelectAll() {
		EntityManager em = JpaDaoFactory.getEntityManager();
		TypedQuery<Capitolo> q = em.createQuery("select c from Capitolo c where c.isVisibleToAll = true", Capitolo.class);
		return(q.getResultList());
	}
}
