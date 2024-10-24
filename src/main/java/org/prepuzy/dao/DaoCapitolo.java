package org.prepuzy.dao;

import java.util.List;

import org.prepuzy.model.Capitolo;
import org.prepuzy.model.Mappa;

public interface DaoCapitolo {
	void insert(Capitolo c);
	void update(Capitolo c);
	void updateConMappa (Capitolo c, Mappa m);
	boolean delete(long id);
	List<Capitolo> selectAll();
	List<Capitolo> filtroSelectAll();
	List<Capitolo> SelectAllWithMappe();
	Capitolo selectById(long id);
}
