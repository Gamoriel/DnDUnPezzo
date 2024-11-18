package org.prepuzy.dao.JPA;

import org.prepuzy.dao.DaoEquipaggiamento;
import org.prepuzy.model.Equipaggiamento;
import org.prepuzy.model.Nave;
import org.prepuzy.model.Oggetto;
import org.prepuzy.model.Personaggio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class JpaDaoEquipaggiamento implements DaoEquipaggiamento {
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
	    EntityTransaction t = em.getTransaction();

	    try {
	        t.begin();
	        em.merge(eq);
	        em.flush();
	        t.commit();
	    } catch (Exception e) {
	        if (t.isActive()) {
	            t.rollback();
	        }
	        throw new RuntimeException("Errore durante l'inserimento dell'equipaggiamento", e);
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
	    Equipaggiamento eq = em.find(Equipaggiamento.class, id);
	    if (eq != null) {
		for (Oggetto o : eq.getOggetti()) {
		    o.setEquipaggiamento(null);
		    em.merge(o);
		}
		em.remove(eq);
		return true;
	    }
	    t.commit();
	} catch (Exception e) {
	    if (t.isActive()) {
		t.rollback();
	    }
	    throw new RuntimeException("Errore durante l'eliminazione dell'equipaggiamento", e);
	} finally {
	    em.close();
	}

	return false;
    }

    @Override
    public void update(Equipaggiamento eq) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	EntityTransaction t = em.getTransaction();
	try {
	    t.begin();
	    em.merge(eq);
	    em.flush();
	    t.commit();
	} catch (Exception e) {
	    if (t.isActive()) {
		t.rollback();
	    }
	    throw new RuntimeException("Errore durante la modifica dell'equipaggiamento", e);
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

    @Override
    public void updateEquipPersoInv(Equipaggiamento equip, Personaggio personaggio, Oggetto oggetto) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	EntityTransaction t = em.getTransaction();
	try {
	    t.begin();
	    em.merge(equip);
	    em.merge(personaggio);
	    em.merge(oggetto);
	    t.commit();
	} catch (Exception e) {
	    if (t.isActive()) {
		t.rollback();
	    }
	    throw new RuntimeException("Errore durante l'aggiornamento dell'equipaggiamento e dell'inventario", e);
	} finally {
	    em.close();
	}
    }

    @Override
    public void updateEquipNaveInv(Equipaggiamento equip, Nave nave, Oggetto oggetto) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	EntityTransaction t = em.getTransaction();
	try {
	    t.begin();
	    em.merge(equip);
	    em.merge(nave);
	    em.merge(oggetto);
	    t.commit();
	} catch (Exception e) {
	    if (t.isActive()) {
		t.rollback();
	    }
	    throw new RuntimeException("Errore durante l'aggiornamento dell'equipaggiamento e dell'inventario", e);
	} finally {
	    em.close();
	}
    }

    @Override
    public Equipaggiamento equipByIdNave(long id) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	String query = "select e from Equipaggiamento e where e.nave.id = :id";
	return em.createQuery(query, Equipaggiamento.class).setParameter("id", id).getSingleResult();
    }

}
