package org.prepuzy.dao.JPA;

import org.prepuzy.dao.DaoEquipaggiamento;
import org.prepuzy.model.Equipaggiamento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class JpaDaoEquipaggiamento implements DaoEquipaggiamento{
	private static JpaDaoEquipaggiamento instance;
	
	public static JpaDaoEquipaggiamento getInstance() {
		if (instance == null) {
			instance = new JpaDaoEquipaggiamento();
		}
		return instance;
	}

	@Override
	public void insert(Equipaggiamento eq) {
	    EntityManager em = JpaDaoFactory.getEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	    
	    try {
	        transaction.begin();
	        em.persist(eq);
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction.isActive()) {
	            transaction.rollback();
	        }
	        throw new RuntimeException("Errore durante l'inserimento dell'equipaggiamento", e);
	    } finally {
	        em.close();
	    }
	}

	@Override
	public boolean delete(long id) {
	    EntityManager em = JpaDaoFactory.getEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	    boolean deleted = false;

	    try {
	        transaction.begin();
	        Equipaggiamento eq = em.find(Equipaggiamento.class, id);
	        if (eq != null) {
	            em.remove(eq); 
	            deleted = true;
	        }
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction.isActive()) {
	            transaction.rollback();
	        }
	        throw new RuntimeException("Errore durante l'eliminazione dell'equipaggiamento", e);
	    } finally {
	        em.close();
	    }

	    return deleted;
	}

	@Override
	public void update(Equipaggiamento eq) {
		 EntityManager em = JpaDaoFactory.getEntityManager();
		    EntityTransaction transaction = em.getTransaction();
		    
		    try {
		        transaction.begin();
		        Equipaggiamento existingEquipaggiamento = em.find(Equipaggiamento.class, eq.getId());
		        if (existingEquipaggiamento != null) {		            
		            em.merge(existingEquipaggiamento);
		        } else {
		            throw new RuntimeException("Equipaggiamento non trovato con ID: " + eq.getId());
		        }
		        transaction.commit();
		    } catch (Exception e) {
		        if (transaction.isActive()) {
		            transaction.rollback();
		        }
		        throw new RuntimeException("Errore durante l'aggiornamento dell'equipaggiamento", e);
		    } finally {
		        em.close();
		    }
	}

	@Override
	public Equipaggiamento equipByIdPersonaggio(long id) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		String query = "select e from Equipaggiamento e where e.personaggio.id = :id";
		return em.createQuery(query, Equipaggiamento.class).setParameter("id", id).getSingleResult();
	}

}
