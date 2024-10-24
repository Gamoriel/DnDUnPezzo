package org.prepuzy.dao;

import java.util.List;

import org.prepuzy.model.Tipologia;

public interface DaoTipologia {
	void insert(Tipologia t);
	Tipologia selectById(long id);
	List<Tipologia> selectAll();
	void update(Tipologia t);
	boolean delete(long id);
}
