package org.prepuzy.dao;

import java.util.List;

import org.prepuzy.model.Oggetto;

public interface DaoOggetto {
	void insert(Oggetto o);
	Oggetto selectById(long id);
	void update(Oggetto o);
	boolean delete(long id);
	List<Oggetto> selectAll();
	List<Oggetto> filtroSelectAll();
}
