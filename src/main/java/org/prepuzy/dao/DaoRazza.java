package org.prepuzy.dao;

import java.util.List;

import org.prepuzy.model.Razza;

public interface DaoRazza {
	void insert(Razza r);
	List<Razza> selectAll();
	Razza selectById(long id);
	void update(Razza r);
	boolean delete(long id);
}
