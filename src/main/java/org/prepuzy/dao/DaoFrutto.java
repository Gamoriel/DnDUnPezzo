package org.prepuzy.dao;

import java.util.List;

import org.prepuzy.model.AbilitaFrutto;
import org.prepuzy.model.Frutto;

public interface DaoFrutto {
	void insert(Frutto f);
	void insertAbilita(AbilitaFrutto a);
	List<Frutto> selectAll();
	List<Frutto> filtroSelectAll();
	Frutto selectById(long id);
	AbilitaFrutto abilitaById(long id);
	List<AbilitaFrutto> selectAllAblitaFrutto();
	List<AbilitaFrutto> selectAllAblitaFruttoByFrutto(long id);
	void update(Frutto f);
	boolean deleteAbilita(long id);
	void updateAbilita(AbilitaFrutto a);
	boolean delete(long id);
}
