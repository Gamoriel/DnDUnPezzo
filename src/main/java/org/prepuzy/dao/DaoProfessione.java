package org.prepuzy.dao;



import java.util.List;

import org.prepuzy.model.AbilitaProfessione;
import org.prepuzy.model.Professione;

public interface DaoProfessione {
	void insert(Professione p);
	void insertAbilita(AbilitaProfessione a);
	List<Professione> selectAll();
	Professione selectbyId(long id);
	AbilitaProfessione abilitaById(long id);
	List<AbilitaProfessione> selectAllAblitaProfessione();
	void update(Professione p);
	void updateAbilita(AbilitaProfessione a);
	boolean delete(long id);
	boolean deleteAbilita(long id);
}
