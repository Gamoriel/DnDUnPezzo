package org.prepuzy.dao;

import java.util.List;

import org.prepuzy.model.Nave;

public interface DaoNave {
	void insert(Nave n);
	List<Nave> selectAll();
	List<Nave> filtroSceletAll();
	Nave selectById(long id);
	void update(Nave n);
	boolean delete(long id);
}
