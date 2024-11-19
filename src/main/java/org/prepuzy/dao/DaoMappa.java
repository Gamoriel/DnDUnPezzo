package org.prepuzy.dao;


import java.util.List;

import org.prepuzy.model.Mappa;

public interface DaoMappa {
	void insert(Mappa m);
	Mappa selectById(long id);
	List<Mappa> listaMappe();
	List<Mappa> filtroSelectAll();
	List<Mappa> mappePadre();
	void update(Mappa m);
	void delete(long id);
}
