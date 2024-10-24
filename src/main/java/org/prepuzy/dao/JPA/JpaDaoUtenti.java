package org.prepuzy.dao.JPA;

import java.util.List;

import org.prepuzy.dao.DaoUtenti;
import org.prepuzy.model.AbilitaFrutto;
import org.prepuzy.model.AbilitaProfessione;
import org.prepuzy.model.Personaggio;
import org.prepuzy.model.Utente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class JpaDaoUtenti implements DaoUtenti{
	private static JpaDaoUtenti instance;

	@Override
	public void insert(Utente utente) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
        if (utente.getId() == 0) {
            em.persist(utente);
        } else {
            em.merge(utente);
        }
		t.commit();
	}
	
	
	public static JpaDaoUtenti getInstance() {
		if (instance == null) {
			instance = new JpaDaoUtenti();
		}
		return instance;
	}


	@Override
	public Utente selectById(long id) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		return (Utente) em.createQuery("select u from Utenti u where id =:id and cancellato = false").setParameter("id", id).getSingleResult();
	}


	@Override
	public Utente selectByUsernamePassword(Utente utente) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		try {			
			return em.createQuery("select u from Utente u WHERE u.username = :username AND u.password = :password", Utente.class).setParameter("username", utente.getUsername()).setParameter("password", utente.getPassword()).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}


	@Override
	public List<Personaggio> personaggiUtente(long id) {
	    EntityManager em = JpaDaoFactory.getEntityManager();
	    List<Personaggio> personaggi = null; 
	    try {
	        TypedQuery<Personaggio> q = em.createQuery("SELECT p FROM Personaggio p WHERE p.utente.id = :id", Personaggio.class);
	        q.setParameter("id", id);
	        personaggi = q.getResultList();
	    } finally {
	        em.close();
	    }
	    return personaggi;
	}


	@Override
	public List<AbilitaFrutto> abilitaFruttoUtente(long id) {
	    EntityManager em = JpaDaoFactory.getEntityManager();
	    TypedQuery<AbilitaFrutto> query = em.createQuery("SELECT a FROM AbilitaFrutto a JOIN a.visibileAPersonaggio p WHERE p.utente.id = :id", AbilitaFrutto.class);
	    query.setParameter("id", id);
	    return query.getResultList();
	}


	@Override
	public List<AbilitaProfessione> abilitaProfessioneUtente(long id) {
	    EntityManager em = JpaDaoFactory.getEntityManager();
	    TypedQuery<AbilitaProfessione> query = em.createQuery("SELECT a FROM AbilitaProfessione a JOIN a.visibileAPersonaggio p WHERE p.utente.id = :id", AbilitaProfessione.class);
	    query.setParameter("id", id);
	    return query.getResultList();
	}


	@Override
	public void update(Utente u) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		
		Utente utenteEsistente = em.find(Utente.class, u.getId());
		if (utenteEsistente != null) {
			utenteEsistente.setUsername(u.getUsername());
			utenteEsistente.setPassword(u.getUsername());
			utenteEsistente.setRole(u.getRole());
			if(u.getPersonaggio() != null) {				
				utenteEsistente.setPersonaggio(u.getPersonaggio());
			}
			em.merge(utenteEsistente);
		} else {
			throw new EntityNotFoundException("Utente non trovato per ID: " + u.getId());
		}
		
	}


	@Override
	public boolean delete(long id) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();

		try {
			t.begin();
			Utente u = em.find(Utente.class, id);
			if (u != null) {
				em.remove(u);
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
}
