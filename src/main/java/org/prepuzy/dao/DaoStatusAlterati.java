package org.prepuzy.dao;

import java.util.List;

import org.prepuzy.model.StatusAlterati;

public interface DaoStatusAlterati {
	void insert(StatusAlterati s);
	List<StatusAlterati> selectAll();
	StatusAlterati selectById(long id);
	void update(StatusAlterati s);
	boolean delete(long id);
}
