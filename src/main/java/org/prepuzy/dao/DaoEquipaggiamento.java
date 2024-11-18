package org.prepuzy.dao;

import org.prepuzy.model.Equipaggiamento;
import org.prepuzy.model.Nave;
import org.prepuzy.model.Oggetto;
import org.prepuzy.model.Personaggio;

public interface DaoEquipaggiamento {
	void insert(Equipaggiamento e);
	boolean delete (long id);
	void update(Equipaggiamento e);
	void updateEquipPersoInv(Equipaggiamento equip, Personaggio personaggio, Oggetto oggetto);
	void updateEquipNaveInv(Equipaggiamento equip, Nave nave, Oggetto oggetto);
	Equipaggiamento equipByIdPersonaggio(long id);
	Equipaggiamento equipByIdNave(long id);
}
