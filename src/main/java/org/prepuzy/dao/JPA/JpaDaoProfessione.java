package org.prepuzy.dao.JPA;

import java.util.List;

import org.prepuzy.dao.DaoProfessione;
import org.prepuzy.model.AbilitaProfessione;
import org.prepuzy.model.Oggetto;
import org.prepuzy.model.Personaggio;
import org.prepuzy.model.Professione;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class JpaDaoProfessione implements DaoProfessione {
    private static JpaDaoProfessione instance;

    public static JpaDaoProfessione getInstance() {
	if (instance == null) {
	    instance = new JpaDaoProfessione();
	}
	return instance;
    }

    @Override
    public List<Professione> selectAll() {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    TypedQuery<Professione> q = em.createQuery("select p from Professione p", Professione.class);
	    return (q.getResultList());
	} finally {
	    em.close();
	}

    }

    @Override
    public Professione selectbyId(long id) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    return em.find(Professione.class, id);
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}
    }

    @Override
    public void update(Professione p) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	EntityTransaction t = em.getTransaction();
	try {
	    t.begin();
	    Professione professioneEsistente = em.find(Professione.class, p.getId());
	    if (professioneEsistente != null) {
		professioneEsistente.setNome(p.getNome());
		professioneEsistente.setDescrizione(p.getDescrizione());
		professioneEsistente.setForza(p.getForza());
		professioneEsistente.setDestrezza(p.getDestrezza());
		professioneEsistente.setCostituzione(p.getCostituzione());
		professioneEsistente.setIntelligenza(p.getIntelligenza());
		professioneEsistente.setSaggezza(p.getSaggezza());
		professioneEsistente.setCarisma(p.getCarisma());
		professioneEsistente.setHp(p.getHp());
		for (AbilitaProfessione abilita : p.getAbilitaProfessione()) {
		    if (!professioneEsistente.getAbilitaProfessione().contains(abilita)) {
			abilita.setProfessione(professioneEsistente);
			em.merge(abilita);
		    }
		}
		professioneEsistente.setAbilitaProfessione(p.getAbilitaProfessione());
		em.merge(professioneEsistente);
	    } else {
		throw new RuntimeException("Professione non trovata con ID: " + p.getId());
	    }

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
	    Professione professione = em.find(Professione.class, id);
	    if (professione != null) {
		for (AbilitaProfessione abilita : professione.getAbilitaProfessione()) {
		    abilita.setProfessione(null);
		    em.merge(abilita);
		}
		for (Personaggio p : professione.getPersonaggi()) {
		    p.setProfessioni(null);
		    em.merge(p);
		}
		for (Oggetto o : professione.getOggetto()) {
		    o.setProfessioni(null);
		    em.merge(o);
		}
		em.remove(professione);
		t.commit();
		return true;
	    } else {
		return false;
	    }
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
    public void insert(Professione p) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	EntityTransaction t = em.getTransaction();

	try {
	    t.begin();
	    em.merge(p);
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
    public AbilitaProfessione abilitaById(long id) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    String query = "select a from AbilitaProfessione a where a.id = :id";
	    return em.createQuery(query, AbilitaProfessione.class).setParameter("id", id).getSingleResult();
	} finally {
	    em.close();
	}

    }

    @Override
    public List<AbilitaProfessione> selectAllAblitaProfessione() {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    String jpql = "select a from AbilitaProfessione a";
	    return (em.createQuery(jpql, AbilitaProfessione.class).getResultList());
	} finally {
	    em.close();
	}
    }

    @Override
    public void insertAbilita(AbilitaProfessione a) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	EntityTransaction t = em.getTransaction();

	try {
	    t.begin();
	    em.merge(a);
	    t.commit();
	} catch (Exception e) {
	    if (t.isActive()) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    em.close();
	}
    }

    @Override
    public void updateAbilita(AbilitaProfessione a) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	EntityTransaction t = em.getTransaction();
	try {
	    t.begin();
	    AbilitaProfessione existingAbilita = em.find(AbilitaProfessione.class, a.getId());
	    if (existingAbilita != null) {
		for (Personaggio p : existingAbilita.getVisibileAPersonaggio()) {
		    p.getAbilitaProfessioneVisibileAPersonaggio().remove(existingAbilita);
		}
		existingAbilita.setNome(a.getNome());
		existingAbilita.setDescrizione(a.getDescrizione());
		List<Personaggio> newVisibleCharacters = a.getVisibileAPersonaggio();
		existingAbilita.setVisibileAPersonaggio(newVisibleCharacters);
		for (Personaggio p : newVisibleCharacters) {
		    if (!p.getAbilitaProfessioneVisibileAPersonaggio().contains(existingAbilita)) {
			p.getAbilitaProfessioneVisibileAPersonaggio().add(existingAbilita);
		    }
		}
		em.merge(existingAbilita);
		em.flush();
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
    public boolean deleteAbilita(long id) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	EntityTransaction t = em.getTransaction();

	try {
	    t.begin();
	    AbilitaProfessione abilita = em.find(AbilitaProfessione.class, id);
	    if (abilita != null) {
		em.remove(abilita);
		t.commit();
		return true;
	    } else {
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
    public List<AbilitaProfessione> selectAllAblitaProfessioneByProfessione(long id) {
	EntityManager em = JpaDaoFactory.getEntityManager();
	try {
	    String jpql = "select a from AbilitaProfessione a where a.professione.id = :id";
	    return (em.createQuery(jpql, AbilitaProfessione.class).setParameter("id", id).getResultList());
	} finally {
	    em.close();
	}
    }
}
