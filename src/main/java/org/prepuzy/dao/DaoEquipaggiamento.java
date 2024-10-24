package org.prepuzy.dao;

import org.prepuzy.model.Equipaggiamento;

public interface DaoEquipaggiamento {
	void insert(Equipaggiamento e);
	boolean delete (long id);
	void update(Equipaggiamento e);
	Equipaggiamento equipByIdPersonaggio(long id);
}
