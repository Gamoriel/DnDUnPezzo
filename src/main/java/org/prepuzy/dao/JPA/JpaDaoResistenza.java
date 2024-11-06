package org.prepuzy.dao.JPA;

import java.util.ArrayList;
import java.util.List;

import org.prepuzy.dao.DaoResistenza;
import org.prepuzy.model.Oggetto;
import org.prepuzy.model.Resistenza;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class JpaDaoResistenza implements DaoResistenza {
	private static JpaDaoResistenza instance;

	public static JpaDaoResistenza getInstance() {
		if (instance == null) {
			instance = new JpaDaoResistenza();
		}
		return instance;
	}

	@Override
	public List<Resistenza> selectAll() {
		EntityManager em = JpaDaoFactory.getEntityManager();
		List<Resistenza> resistenze = new ArrayList<>();
		try {
			TypedQuery<Resistenza> q = em.createQuery("select r from Resistenza r", Resistenza.class);
			resistenze = (q.getResultList());
		} finally {
			em.close();
		}
		return resistenze;
	}

	@Override
	public Resistenza selectById(long id) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		Resistenza resistenza = null;
		try {
			resistenza = em.find(Resistenza.class, id);
		} finally {
			em.close();
		}

		return resistenza;
	}

	@Override
	public void update(Resistenza r) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();

		try {
			t.begin();
			em.merge(r);
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
			Resistenza resistenza = em.find(Resistenza.class, id);
			if (resistenza != null) {
				if (resistenza.getOggetto() != null) {
					for (Oggetto oggetto : resistenza.getOggetto()) {
						oggetto.getResistenze().remove(resistenza);
						em.merge(oggetto);
					}
					resistenza.getOggetto().clear();
				}
				if (resistenza.getFrutto() != null) {
					resistenza.setFrutto(null);
				}
				em.remove(resistenza);
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
	public void insert(Resistenza r) {
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
