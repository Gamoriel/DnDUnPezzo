package org.prepuzy.dao.JPA;

import java.util.List;

import org.prepuzy.dao.DaoPersonaggio;
import org.prepuzy.model.Equipaggiamento;
import org.prepuzy.model.Inventario;
import org.prepuzy.model.OggettiMercante;
import org.prepuzy.model.Personaggio;
import org.prepuzy.model.Tecniche;

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
	try {
	    t.begin();
	    Equipaggiamento equip = new Equipaggiamento();
	    p.setEquip(equip);
	    equip.setPersonaggio(p);
	    em.persist(equip);
	    Inventario inventario = new Inventario();
	    p.setInventario(inventario);
	    inventario.setPersonaggio(p);
	    em.persist(inventario);
	    em.merge(p);
	    t.commit();
	} catch (Exception e) {
	    if (t.isActive()) {
		t.rollback();
	    }
	    throw new RuntimeException("Errore durante l'inserimento del personaggio", e);
	} finally {
	    em.close();
	}
    }

    @Override
    public void update(Personaggio p) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	EntityTransaction t = em.getTransaction();
	try {
	    t.begin();
	    Personaggio existingPersonaggio = em.find(Personaggio.class, p.getId());
	    if (existingPersonaggio != null) {
		if (p.getUrlImmagine() == null || p.getUrlImmagine().isEmpty()) {
		    p.setUrlImmagine(existingPersonaggio.getUrlImmagine());
		}
		if (p.getTaglia() == null || p.getTaglia().isEmpty()) {
		    p.setTaglia(existingPersonaggio.getTaglia());
		}
	    }
	    em.merge(p);
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
		em.remove(personaggio);
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
	}

	return personaggio;
    }

    @Override
    public List<Personaggio> filtroSelectAll() {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    TypedQuery<Personaggio> q = em.createQuery("select p from Personaggio p where p.isVisibleToAll = true",
		    Personaggio.class);
	    return (q.getResultList());
	} finally {
	    em.close();
	}

    }

    @Override
    public List<Personaggio> listaMercanti() {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    TypedQuery<Personaggio> q = em.createQuery("select p FROM Personaggio p where p.isMercante = true",
		    Personaggio.class);
	    return (q.getResultList());
	} finally {
	    em.close();
	}

    }

    @Override
    public List<OggettiMercante> inventarioMercante(Personaggio mercante) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    return em.createQuery("SELECT o FROM OggettiMercante o WHERE o.mercante = :mercante", OggettiMercante.class)
		    .setParameter("mercante", mercante).getResultList();
	} finally {
	    em.close();
	}
    }

    @Override
    public void aggiornaPrezzi(List<OggettiMercante> oggettiDaAggiornare) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	EntityTransaction t = em.getTransaction();
	try {
	    t.begin();
	    for (OggettiMercante oggetto : oggettiDaAggiornare) {
		OggettiMercante dbOggetto = em.find(OggettiMercante.class, oggetto.getId());
		if (dbOggetto != null) {
		    dbOggetto.setPrezzo(oggetto.getPrezzo());
		    em.merge(dbOggetto);
		}
	    }
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
	    String query = "select p from Personaggio p where p.utente.id > 1";
	    return em.createQuery(query, Personaggio.class).getResultList();
	} finally {
	    em.close();
	}
    }

    @Override
    public void insertTecniche(Tecniche te) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	EntityTransaction t = em.getTransaction();
	try {
	    t.begin();
	    if (te.getId() == 0) {
		em.persist(te);
	    } else {
		em.merge(te);
	    }
	    t.commit();
	} finally {
	    em.close();
	}

    }

    @Override
    public void updateTecniche(Tecniche te) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	EntityTransaction t = em.getTransaction();
	try {
	    t.begin();
	    em.merge(te);
	    t.commit();
	} catch (Exception e) {
	    if (t.isActive()) {
		t.rollback();
	    }
	    throw new RuntimeException("Errore durante l'aggiornamento della tecnica: " + e.getMessage(), e);
	} finally {
	    em.close();
	}
    }

    @Override
    public boolean deleteTecniche(long id) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	EntityTransaction t = em.getTransaction();
	try {
	    t.begin();
	    Tecniche tecnica = em.find(Tecniche.class, id);
	    if (tecnica != null) {
		em.remove(tecnica);
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
    public List<Tecniche> listaTecniche() {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    TypedQuery<Tecniche> q = em.createQuery("select t from Tecniche t", Tecniche.class);
	    return (q.getResultList());
	} finally {
	    em.close();
	}

    }

    @Override
    public List<Tecniche> listaTecnicheByPersonaggioId(long id) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    TypedQuery<Tecniche> q = em.createQuery(
		    "select t from Tecniche t JOIN t.visibileAPersonaggio p where p.id = :id", Tecniche.class);
	    return (q.getResultList());
	} finally {
	    em.close();
	}
    }

    @Override
    public Tecniche selectTecnicaById(long id) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	EntityTransaction t = em.getTransaction();
	Tecniche te = null;

	try {
	    t.begin();
	    te = em.find(Tecniche.class, id);
	    t.commit();
	} catch (Exception e) {
	    if (t.isActive()) {
		t.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    em.close();
	}

	return te;
    }

    @Override
    public List<Personaggio> listaPersonaggiConTaglia() {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    TypedQuery<Personaggio> q = em.createQuery("select p from Personaggio p where p.taglia is not null",
		    Personaggio.class);
	    return q.getResultList();
	} finally {
	    em.close();
	}
    }

    @Override
    public List<Personaggio> listaPersonaggiNPC() {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    String query = "select p from Personaggio p where p.utente.id = 1";
	    return em.createQuery(query, Personaggio.class).getResultList();
	} finally {
	    em.close();
	}
    }

    @Override
    public List<Personaggio> selectNPCVisibileToUtenti() {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    String query = "select p from Personaggio p where p.utente.id = 1 and p.isVisibleToAll = true";
	    return em.createQuery(query, Personaggio.class).getResultList();
	} finally {
	    em.close();
	}
    }

}
