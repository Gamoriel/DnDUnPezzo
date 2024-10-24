package org.prepuzy.dao;



import java.util.List;

import org.prepuzy.model.OggettiMercante;
import org.prepuzy.model.Personaggio;

public interface DaoPersonaggio {
	void insert(Personaggio p);
	void update (Personaggio p);
	boolean delete (long id);
	Personaggio selectById(long id);
	List<OggettiMercante> inventarioMercante(Personaggio p);
	List<Personaggio> listaPersonaggi();
	List<Personaggio> listaPersonaggiUtente();
	List<Personaggio> filtroSelectAll();
	List<Personaggio> listaMercanti();
	Personaggio PersonaggioConTuttiElementi(long id);
	void aggiornaPrezzo(OggettiMercante o, long prezzo);
	void insertOggettoMercante(OggettiMercante o);
}
