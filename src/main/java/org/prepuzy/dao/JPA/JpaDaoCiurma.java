package org.prepuzy.dao.JPA;


import java.util.List;

import org.prepuzy.dao.DaoCiurma;
import org.prepuzy.model.Ciurma;
import org.prepuzy.model.Personaggio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class JpaDaoCiurma implements DaoCiurma {
	private static JpaDaoCiurma instance;

	public static JpaDaoCiurma getInstance() {
		if (instance == null) {
			instance = new JpaDaoCiurma();
		}
		return instance;
	}

	@Override
	public void insert(Ciurma c) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		if (c.getId() == 0) {
			em.persist(c);
		} else {
			em.merge(c);
		}
		t.commit();
		em.close();
	}

	@Override
	public List<Ciurma> listaCiurme() {
		EntityManager em = JpaDaoFactory.getEntityManager();
		try {
			TypedQuery<Ciurma> q = em.createQuery("select c from Ciurma c", Ciurma.class);
			return(q.getResultList());			
		}finally {
			em.close();
		}
	}

	@Override
	public Ciurma selectById(long id) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		try {
			String query = "select c from Ciurma c left join fetch c.personaggi left join fetch c.nave where c.id = :id";
			return em.createQuery(query, Ciurma.class).setParameter("id", id).getSingleResult();
		} finally {
			em.close();
		}
	}

	@Override
	public void delete(long id) {
	    EntityManager em = JpaDaoFactory.getEntityManager();
	    EntityTransaction t = em.getTransaction();
	    try {
	        t.begin();

	        Ciurma ciurma = em.find(Ciurma.class, id);
	        if (ciurma != null) {
	            em.remove(ciurma);
	        } else {
	            throw new EntityNotFoundException("Ciurma non trovata per ID: " + id);
	        }

	        t.commit();
	    } catch (Exception e) {
	        if (t.isActive()) {
	            t.rollback();
	        }
	        throw new RuntimeException("Errore durante l'eliminazione della ciurma", e);
	    } finally {
	        em.close();
	    }
	}

	@Override
	public void update(Ciurma c) {
	    EntityManager em = JpaDaoFactory.getEntityManager();
	    EntityTransaction t = em.getTransaction();
	    try {
	        t.begin();
	        Ciurma existingCiurma = em.find(Ciurma.class, c.getId());
	        if (existingCiurma != null) {
	            existingCiurma.setNome(c.getNome());
	            existingCiurma.setJollyRoger(c.getJollyRoger());
	            existingCiurma.setDescrizione(c.getDescrizione());
	            if (c.getPersonaggi() != null) {
	                existingCiurma.setPersonaggi(c.getPersonaggi());
	            }
	            if (c.getNave() != null) {
	                existingCiurma.setNave(c.getNave());
	            }
	            em.merge(existingCiurma);
	        } else {
	            throw new EntityNotFoundException("Ciurma non trovata per ID: " + c.getId());
	        }

	        t.commit();
	    } catch (Exception e) {
	        if (t.isActive()) {
	            t.rollback();
	        }
	        throw new RuntimeException("Errore durante l'aggiornamento della ciurma", e);
	    } finally {
	        em.close();
	    }
	}

	@Override
	public void rimuovipersonaggioDaCiurma(long idciurma, long idpersonaggio) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();

		try {
			t.begin();
			Ciurma ciurma = em.find(Ciurma.class, idciurma);
			if (ciurma == null) {
				throw new RuntimeException("Ciurma non trovata con ID: " + idciurma);
			}
			Personaggio personaggio = em.find(Personaggio.class, idpersonaggio);
			if (personaggio == null) {
				throw new RuntimeException("Personaggio non trovato con ID: " + idpersonaggio);
			}
			personaggio.setCiurma(null);
			em.merge(personaggio);
			t.commit();
		} catch (Exception e) {
			if (t.isActive()) {
				t.rollback();
			}
			throw new RuntimeException("Errore durante la rimozione del personaggio dalla ciurma: " + e.getMessage(),
					e);
		} finally {
			em.close();
		}
	}

	@Override
	public void aggiungiPersonaggioACiurma(long idciurma, long idpersonaggio) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();

		try {
			t.begin();
			Ciurma ciurma = em.find(Ciurma.class, idciurma);
			if (ciurma == null) {
				throw new RuntimeException("Ciurma non trovata con ID: " + idciurma);
			}

			Personaggio personaggio = em.find(Personaggio.class, idpersonaggio);
			if (personaggio == null) {
				throw new RuntimeException("Personaggio non trovato con ID: " + idpersonaggio);
			}

			personaggio.setCiurma(ciurma);
			em.merge(personaggio);

			t.commit();
		} catch (Exception e) {
			if (t.isActive()) {
				t.rollback();
			}
			throw new RuntimeException("Errore durante l'aggiunta del personaggio alla ciurma: " + e.getMessage(), e);
		} finally {
			em.close();
		}
	}

	@Override
	public List<Personaggio> membriCiurma(long id) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		List<Personaggio> membri = null;

		try {
			t.begin();

			membri = (em.createQuery("SELECT m FROM Personaggio m JOIN m.ciurma c WHERE c.id = :id", Personaggio.class)
					.setParameter("id", id).getResultList());

			t.commit();
		} catch (Exception e) {
			if (t.isActive()) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}

		return membri;
	}

	@Override
	public List<Ciurma> filtroSelectAll() {
		EntityManager em = JpaDaoFactory.getEntityManager();
		try {
			TypedQuery<Ciurma> q = em.createQuery("select c from Ciurma c where c.isVisibleToAll = true", Ciurma.class);
			return(q.getResultList());
		} finally {
			em.close();
		}
	}
}
