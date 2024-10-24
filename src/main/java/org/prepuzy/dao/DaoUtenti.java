package org.prepuzy.dao;

import java.util.List;

import org.prepuzy.model.AbilitaFrutto;
import org.prepuzy.model.AbilitaProfessione;
import org.prepuzy.model.Personaggio;
import org.prepuzy.model.Utente;

public interface DaoUtenti {
	void insert(Utente u);
	void update(Utente u);
	boolean delete(long id);
	Utente selectById(long id);
	Utente selectByUsernamePassword(Utente u);
	List<Personaggio> personaggiUtente(long id);
	List<AbilitaFrutto> abilitaFruttoUtente(long id);
	List<AbilitaProfessione> abilitaProfessioneUtente(long id);
}
