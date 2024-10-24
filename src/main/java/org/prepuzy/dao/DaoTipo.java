package org.prepuzy.dao;

import java.util.List;

import org.prepuzy.model.Tipo;

public interface DaoTipo {
	void insert(Tipo t);
	List<Tipo> selectAll();
	Tipo selectById(long id);
	void update(Tipo t);
	boolean delete(long id);
}
