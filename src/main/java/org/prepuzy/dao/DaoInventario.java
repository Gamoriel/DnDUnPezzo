package org.prepuzy.dao;

import org.prepuzy.model.Inventario;

public interface DaoInventario {
	Inventario selectById(long id);
	void insert(Inventario i);
	void update(Inventario i);
	boolean delete (long id);
}
