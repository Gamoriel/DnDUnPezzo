package org.prepuzy.dao.JPA;

import java.util.List;

import org.prepuzy.dao.DaoFrutto;
import org.prepuzy.model.AbilitaFrutto;
import org.prepuzy.model.Frutto;
import org.prepuzy.model.Personaggio;
import org.prepuzy.model.Qualita;
import org.prepuzy.model.Resistenza;
import org.prepuzy.model.Tipo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class JpaDaoFrutto implements DaoFrutto {
	private static JpaDaoFrutto instance;

	public static JpaDaoFrutto getInstance() {
		if (instance == null) {
			instance = new JpaDaoFrutto();
		}
		return instance;
	}

	@Override
	public List<Frutto> selectAll() {
		EntityManager em = JpaDaoFactory.getEntityManager();
		try {
			String jpql = "SELECT f FROM Frutto f";
			return (em.createQuery(jpql, Frutto.class).getResultList());
		} finally {
			em.close();
		}
	}

	@Override
	public Frutto selectById(long id) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		try {
			String query = "SELECT f FROM Frutto f where f.id = :id";
			return em.createQuery(query, Frutto.class).setParameter("id", id).getSingleResult();
		} finally {
			em.close();
		}

	}

	@Override
	public void update(Frutto f) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		try {
			em.getTransaction().begin();
			Frutto fruttoEsistente = em.find(Frutto.class, f.getId());

			if (fruttoEsistente != null) {

				fruttoEsistente.setNome(f.getNome());
				fruttoEsistente.setDescrizione(f.getDescrizione());
				fruttoEsistente.setPrezzo(f.getPrezzo());

				if (f.getTipo() != null) {
					Tipo tipo = em.find(Tipo.class, f.getTipo().getId());
					fruttoEsistente.setTipo(tipo);
				}

				if (f.getQualita() != null) {
					Qualita qualita = em.find(Qualita.class, f.getQualita().getId());
					fruttoEsistente.setQualita(qualita);
				}

				fruttoEsistente.setResistenza((f.getResistenza()));
				fruttoEsistente.setStatus((f.getStatus()));
				fruttoEsistente.setForza(f.getForza());
				fruttoEsistente.setDestrezza(f.getDestrezza());
				fruttoEsistente.setCostituzione(f.getCostituzione());
				fruttoEsistente.setIntelligenza(f.getIntelligenza());
				fruttoEsistente.setSaggezza(f.getSaggezza());
				fruttoEsistente.setCarisma(f.getCarisma());
				fruttoEsistente.setHp(f.getHp());
				fruttoEsistente.setVisibleToAll(f.isVisibleToAll());

				em.merge(fruttoEsistente);
			} else {
				throw new IllegalArgumentException("Frutto non trovato");
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
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
			Frutto frutto = em.find(Frutto.class, id);
			if (frutto != null) {
				for (Resistenza r : frutto.getResistenza()) {
					r.setFrutto(null);
					em.merge(r);
				}
				for (AbilitaFrutto a : frutto.getAbilita()) {
					a.setFrutto(null);
					em.merge(a);
				}
				em.remove(frutto);
				t.commit();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return false;
	}

	@Override
	public void insert(Frutto f) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();

		try {
			t.begin();
			em.merge(f);
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
	public List<Frutto> filtroSelectAll() {
		EntityManager em = JpaDaoFactory.getEntityManager();
		try {
			TypedQuery<Frutto> q = em.createQuery("select f from Frutto f where f.isVisibleToAll = true", Frutto.class);
			return (q.getResultList());
		} finally {
			em.close();
		}

	}

	@Override
	public AbilitaFrutto abilitaById(long id) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		try {
			String query = "select a from AbilitaFrutto a where a.id = :id";
			return em.createQuery(query, AbilitaFrutto.class).setParameter("id", id).getSingleResult();
		} finally {
			em.close();
		}

	}

	@Override
	public List<AbilitaFrutto> selectAllAblitaFrutto() {
		EntityManager em = JpaDaoFactory.getEntityManager();
		try {
			String jpql = "select a from AbilitaFrutto a";
			return (em.createQuery(jpql, AbilitaFrutto.class).getResultList());
		} finally {
			em.close();
		}
	}

	@Override
	public void insertAbilita(AbilitaFrutto a) {
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
	public void updateAbilita(AbilitaFrutto a) {
		EntityManager em = JpaDaoFactory.getEntityManager();
	    EntityTransaction t = em.getTransaction();
	    try {
	        t.begin();
	        AbilitaFrutto existingAbilita = em.find(AbilitaFrutto.class, a.getId());
	        if (existingAbilita != null) {
	            for (Personaggio p : existingAbilita.getVisibileAPersonaggio()) {
	                p.getAbilitaFruttoVisibileAPersonaggio().remove(existingAbilita);
	            }
	            existingAbilita.setNome(a.getNome());
	            existingAbilita.setDescrizione(a.getDescrizione());
	            List<Personaggio> newVisibleCharacters = a.getVisibileAPersonaggio();
	            existingAbilita.setVisibileAPersonaggio(newVisibleCharacters);
	            for (Personaggio p : newVisibleCharacters) {
	                if (!p.getAbilitaFruttoVisibileAPersonaggio().contains(existingAbilita)) {
	                    p.getAbilitaFruttoVisibileAPersonaggio().add(existingAbilita);
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
	        AbilitaFrutto abilita = em.find(AbilitaFrutto.class, id);
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
	public List<AbilitaFrutto> selectAllAblitaFruttoByFrutto(long id) {
		EntityManager em = JpaDaoFactory.getEntityManager();
		try {
			String jpql = "select a from AbilitaFrutto a where a.frutto.id = :id";
			return (em.createQuery(jpql, AbilitaFrutto.class).setParameter("id", id).getResultList());
		} finally {
			em.close();
		}
	}

}
