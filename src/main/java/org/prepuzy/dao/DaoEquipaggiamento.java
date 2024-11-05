package org.prepuzy.dao;

import org.prepuzy.model.Equipaggiamento;
import org.prepuzy.model.Oggetto;
import org.prepuzy.model.Personaggio;

public interface DaoEquipaggiamento {
	void insert(Equipaggiamento e);
	boolean delete (long id);
	void update(Equipaggiamento e);
	void updateEquipPersoInv(Equipaggiamento equip, Personaggio personaggio, Oggetto oggetto);
	Equipaggiamento equipByIdPersonaggio(long id);
}
