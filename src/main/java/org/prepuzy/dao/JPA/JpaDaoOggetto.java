package org.prepuzy.dao.JPA;

import java.util.List;

import org.prepuzy.dao.DaoOggetto;
import org.prepuzy.model.Oggetto;
import org.prepuzy.model.Professione;
import org.prepuzy.model.Razza;
import org.prepuzy.model.Resistenza;
import org.prepuzy.model.StatusAlterati;
import org.prepuzy.model.Tipologia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class JpaDaoOggetto implements DaoOggetto {
	private static JpaDaoOggetto instance;

	public static JpaDaoOggetto getInstance() {
		if (instance == null) {
			instance = new JpaDaoOggetto();
		}
		return instance;
	}

	@Override
	public Oggetto selectById(long id) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		Oggetto oggetto = null;
		try {
			t.begin();
			oggetto = em.find(Oggetto.class, id);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive())
				t.rollback();
			throw e;
		} finally {
			em.close();
		}
		return oggetto;
	}

	@Override
	public void update(Oggetto oggetto) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();

		try {
			t.begin();
			Oggetto oggettoEsistente = em.find(Oggetto.class, oggetto.getId());

			if (oggettoEsistente != null) {
				oggettoEsistente.setNome(oggetto.getNome());
				oggettoEsistente.setDescrizione(oggetto.getDescrizione());
				oggettoEsistente.setPrezzo(oggetto.getPrezzo());
				oggettoEsistente.setForza(oggetto.getForza());
				oggettoEsistente.setDestrezza(oggetto.getDestrezza());
				oggettoEsistente.setCostituzione(oggetto.getCostituzione());
				oggettoEsistente.setIntelligenza(oggetto.getIntelligenza());
				oggettoEsistente.setSaggezza(oggetto.getSaggezza());
				oggettoEsistente.setCarisma(oggetto.getCarisma());
				oggettoEsistente.setHp(oggetto.getHp());
				oggettoEsistente.setPeso(oggetto.getPeso());
				oggettoEsistente.setVisibleToAll(oggetto.isVisibleToAll());
				List<Resistenza> resistenzeEsistenti = oggettoEsistente.getResistenze();
				List<Resistenza> nuoveResistenze = oggetto.getResistenze();
				resistenzeEsistenti.retainAll(nuoveResistenze);
				for (Resistenza nuovaResistenza : nuoveResistenze) {
					if (!resistenzeEsistenti.contains(nuovaResistenza)) {
						resistenzeEsistenti.add(nuovaResistenza);
					}
				}

				List<Razza> razzeEsistenti = oggettoEsistente.getRazze();
				List<Razza> nuoveRazze = oggetto.getRazze();
				razzeEsistenti.retainAll(nuoveRazze);
				for (Razza nuovaRazza : nuoveRazze) {
					if (!razzeEsistenti.contains(nuovaRazza)) {
						razzeEsistenti.add(nuovaRazza);
					}
				}

				List<Professione> professioniEsistenti = oggettoEsistente.getProfessioni();
				List<Professione> nuoveProfessioni = oggetto.getProfessioni();
				professioniEsistenti.retainAll(nuoveProfessioni);
				for (Professione nuovaProfessione : nuoveProfessioni) {
					if (!professioniEsistenti.contains(nuovaProfessione)) {
						professioniEsistenti.add(nuovaProfessione);
					}
				}

				List<StatusAlterati> statusEsistenti = oggettoEsistente.getStatus();
				List<StatusAlterati> nuoviStatus = oggetto.getStatus();
				statusEsistenti.retainAll(nuoviStatus);
				for (StatusAlterati nuovoStatus : nuoviStatus) {
					if (!statusEsistenti.contains(nuovoStatus)) {
						statusEsistenti.add(nuovoStatus);
					}
				}
				Tipologia tipologiaEsistente = em.find(Tipologia.class, oggetto.getTipologia().getId());
				if (tipologiaEsistente != null) {
					oggettoEsistente.setTipologia(tipologiaEsistente);
				}
				em.merge(oggettoEsistente);
			}

			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
			System.err.println("Errore durante l'aggiornamento dell'oggetto: " + e.getMessage());
			throw e;
		} finally {
			em.close();
		}
	}

	@Override
	public boolean delete(long id) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			Oggetto oggetto = em.find(Oggetto.class, id);
			if (oggetto != null) {
				em.remove(oggetto);
				transaction.commit();
				return true;
			} else {
				return false;
			}
		} catch (RuntimeException e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		} finally {
			em.close();
		}
	}

	@Override
	public List<Oggetto> selectAll() {
		EntityManager em = JpaDaoFactory.getEntityManager();
		TypedQuery<Oggetto> query = em.createQuery("SELECT o FROM Oggetto o", Oggetto.class);
		return (query.getResultList());

	}

	@Override
	public void insert(Oggetto o) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();

		try {
			t.begin();
			em.merge(o);
			t.commit();
			System.out.println("Oggetto inserito con successo: " + o);
		} catch (Exception e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
			System.out.println("EntityManager chiuso.");
		}
	}

	@Override
	public List<Oggetto> filtroSelectAll() {
		EntityManager em = JpaDaoFactory.getEntityManager();
		TypedQuery<Oggetto> q = em.createQuery("select o from Oggetto o where o.isVisibleToAll = true", Oggetto.class);
		return (q.getResultList());
	}
}
