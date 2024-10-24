package org.prepuzy.dao.JPA;


import java.util.List;

import org.prepuzy.dao.DaoPersonaggio;
import org.prepuzy.model.Inventario;
import org.prepuzy.model.Nave;
import org.prepuzy.model.OggettiMercante;
import org.prepuzy.model.Personaggio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class JpaDaoPersonaggio implements DaoPersonaggio {
	private static JpaDaoPersonaggio instance;

	public static JpaDaoPersonaggio getInstance() {
		if (instance == null) {
			instance = new JpaDaoPersonaggio();
		}
		return instance;
	}

	@Override
	public void insert(Personaggio p) {
		EntityManager em = JpaDaoFactory.getEntityManager();
	    EntityTransaction t = em.getTransaction();
	    t.begin();
	    Nave nave = p.getNave();
	    if (nave != null) {
	        if (nave.getDeposito() == null) {
	            nave.setDeposito(new Inventario());
	        }
	        if (nave.getId() == 0) {
	            em.persist(nave);
	        } else {
	            em.merge(nave);
	        }
	        p.setNave(nave);
	    }
	    if (p.getId() == 0) {
	        em.persist(p);
	    } else {
	        em.merge(p);
	    }

	    t.commit();
	}

	@Override
	public void update(Personaggio p) {
	    EntityManager em = JpaDaoFactory.getEntityManager();
	    EntityTransaction t = em.getTransaction();
	    try {
	        t.begin();
	        em.merge(p);
	        if (p.getInventario() != null) {
	            em.merge(p.getInventario());
	        }      
	        t.commit();
	    } catch (Exception e) {
	        if (t.isActive()) {
	            t.rollback();
	        }
	        throw new RuntimeException("Errore durante l'aggiornamento del personaggio: " + e.getMessage(), e);
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
	        Personaggio personaggio = em.find(Personaggio.class, id);
	        if (personaggio != null) {
	            System.out.println("Personaggio trovato: " + personaggio.getNome());
	            em.remove(personaggio);
	            t.commit();
	            System.out.println("Personaggio eliminato con successo.");
	            return true;
	        } else {
	            System.out.println("Personaggio con ID " + id + " non trovato.");
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
	public List<Personaggio> listaPersonaggi() {
		EntityManager em = JpaDaoFactory.getEntityManager();
		List<Personaggio> personaggi = null;
		try {
			em.getTransaction().begin();
			personaggi = (em.createQuery("SELECT p FROM Personaggio p", Personaggio.class).getResultList());
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			throw new RuntimeException("Errore durante il recupero della lista di personaggi: " + e.getMessage(), e);
		} finally {
			em.close();
		}
		return personaggi;
	}

	@Override
	public Personaggio PersonaggioConTuttiElementi(long id) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		Personaggio personaggio = null;
		try {
			em.getTransaction().begin();
			String query = "SELECT p FROM Personaggio p WHERE p.id = :id";
			personaggio = em.createQuery(query, Personaggio.class).setParameter("id", id).getSingleResult();

			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			throw new RuntimeException("Errore durante il recupero del personaggio: " + e.getMessage(), e);
		} finally {
			em.close();
		}
		return personaggio;
	}

	@Override
	public Personaggio selectById(long id) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		Personaggio personaggio = null;

		try {
			t.begin();
			personaggio = em.find(Personaggio.class, id);
			t.commit();
		} catch (Exception e) {
			if (t.isActive()) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}

		return personaggio;
	}

	@Override
	public List<Personaggio> filtroSelectAll() {
		EntityManager em = JpaDaoFactory.getEntityManager();
		TypedQuery<Personaggio> q = em.createQuery("select p from Personaggio p where p.isVisibleToAll = true", Personaggio.class);
		return(q.getResultList());
	}

	@Override
	public List<Personaggio> listaMercanti() {
		EntityManager em = JpaDaoFactory.getEntityManager();
		TypedQuery<Personaggio> q = em.createQuery("select p FROM Personaggio p where p.isMercante = true", Personaggio.class);
		return(q.getResultList());
	}

	@Override
	public List<OggettiMercante> inventarioMercante(Personaggio mercante) {
        EntityManager em = JpaDaoFactory.getEntityManager();
        try {
            return em.createQuery("SELECT o FROM OggettiMercante o WHERE o.mercante = :mercante", OggettiMercante.class)
                    .setParameter("mercante", mercante)
                    .getResultList();
        } finally {
            em.close();
        }
	}

	@Override
	public void aggiornaPrezzo(OggettiMercante o, long prezzo) {
        EntityManager em = JpaDaoFactory.getEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            OggettiMercante oggetto = em.find(OggettiMercante.class, o.getId());
            if (oggetto != null) {
                oggetto.setPrezzo(prezzo);
                em.merge(oggetto);
                t.commit();
            }
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
	}

	@Override
	public void insertOggettoMercante(OggettiMercante o) {
	    EntityManager em = JpaDaoFactory.getEntityManager();
	    EntityTransaction t = em.getTransaction();
	    try {
	        t.begin();
	        System.out.println("Persisting OggettiMercante: " + o);
	        em.persist(o);
	        t.commit();
	    } catch (Exception e) {
	        if (t.isActive()) {
	            t.rollback();
	        }
	        System.out.println("Error persisting OggettiMercante: " + e.getMessage());
	    } finally {
	        em.close();
	    }
	}

	@Override
	public List<Personaggio> listaPersonaggiUtente() {
	    EntityManager em = JpaDaoFactory.getEntityManager();
	    try {
	        String query = "select p from Personaggio p where p.utente is not null";
	        return em.createQuery(query, Personaggio.class).getResultList();
	    } finally {
	        em.close();
	    }
	}

}
