package org.prepuzy.dao;


import java.util.List;

import org.prepuzy.model.Qualita;

public interface DaoQualita {
	void insert(Qualita q);
	List<Qualita> selectAll();
	Qualita selectById(long id);
	boolean delete(long id);
}
