package org.prepuzy.dao.JPA;

import java.util.List;

import org.prepuzy.dao.DaoOggetto;
import org.prepuzy.model.Inventario;
import org.prepuzy.model.Oggetto;
import org.prepuzy.model.Professione;
import org.prepuzy.model.Razza;
import org.prepuzy.model.Resistenza;
import org.prepuzy.model.StatusAlterati;

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
		try {
			t.begin();
			Oggetto oggetto = em.find(Oggetto.class, id);
			t.commit();
			return oggetto;
		} catch (RuntimeException e) {
			if (t.isActive())
				t.rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Oggetto oggetto) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			Oggetto oggettoEsistente = em.merge(oggetto);

			List<Resistenza> resistenzeEsistenti = oggettoEsistente.getResistenze();
			List<Razza> razzeEsistenti = oggettoEsistente.getRazze();
			List<Professione> professioniEsistenti = oggettoEsistente.getProfessioni();
			List<StatusAlterati> statusEsistenti = oggettoEsistente.getStatus();
			
			for (Resistenza nuovaResistenza : oggetto.getResistenze()) {
				if (!resistenzeEsistenti.contains(nuovaResistenza)) {
					resistenzeEsistenti.add(nuovaResistenza);
				}
			}
			for (Razza nuovaRazza : oggetto.getRazze()) {
				if (!razzeEsistenti.contains(nuovaRazza)) {
					razzeEsistenti.add(nuovaRazza);
				}
			}
			for (Professione nuovaProfessione : oggetto.getProfessioni()) {
				if (!professioniEsistenti.contains(nuovaProfessione)) {
					professioniEsistenti.add(nuovaProfessione);
				}
			}
			for (StatusAlterati nuovoStatus : oggetto.getStatus()) {
				if (!statusEsistenti.contains(nuovoStatus)) {
					statusEsistenti.add(nuovoStatus);
				}
			}
			em.merge(oggettoEsistente);
			t.commit();
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
	public boolean delete(long id) {
	    EntityManager em = JpaDaoFactory.getEntityManager();
	    EntityTransaction t = em.getTransaction();

	    try {
	        t.begin();
	        Oggetto oggetto = em.find(Oggetto.class, id);
	        if (oggetto != null) {
	            for (Resistenza resistenza : oggetto.getResistenze()) {
	                resistenza.getOggetto().remove(oggetto);
	                em.merge(resistenza);
	            }
	            for (Razza razza : oggetto.getRazze()) {
	                razza.getOggetto().remove(oggetto);
	                em.merge(razza);
	            }
	            for (Professione professione : oggetto.getProfessioni()) {
	                professione.getOggetto().remove(oggetto);
	                em.merge(professione);
	            }
	            for (StatusAlterati status : oggetto.getStatus()) {
	                status.getOggetto().remove(oggetto);
	                em.merge(status);
	            }

	            if (oggetto.getEquipaggiamento() != null) {
	                oggetto.getEquipaggiamento().getOggetti().remove(oggetto);
	                em.merge(oggetto.getEquipaggiamento()); 
	            }

	            for (Inventario inventario : oggetto.getInventari()) {
	                inventario.getOggetti().remove(oggetto);
	                em.merge(inventario);
	            }
	            em.remove(oggetto);
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
		} catch (Exception e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
	}

	@Override
	public List<Oggetto> filtroSelectAll() {
		EntityManager em = JpaDaoFactory.getEntityManager();
		try {
			TypedQuery<Oggetto> q = em.createQuery("select o from Oggetto o where o.isVisibleToAll = true",
					Oggetto.class);
			return (q.getResultList());
		} finally {
			em.close();
		}

	}
}
