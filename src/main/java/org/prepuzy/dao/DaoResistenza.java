package org.prepuzy.dao;

import java.util.List;

import org.prepuzy.model.Resistenza;

public interface DaoResistenza {
	void insert(Resistenza r);
	List<Resistenza> selectAll();
	Resistenza selectById(long id);
	void update(Resistenza r);
	boolean delete(long id);
}
