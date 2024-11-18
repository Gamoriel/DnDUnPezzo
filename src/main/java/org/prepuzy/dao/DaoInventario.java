package org.prepuzy.dao;

import org.prepuzy.model.Inventario;

public interface DaoInventario {
	Inventario selectById(long id);
	Inventario selectByPersonaggioId(long id);
	Inventario selectByNaveId(long id);
	void insert(Inventario i);
	void update(Inventario i);
	boolean delete (long id);
}
