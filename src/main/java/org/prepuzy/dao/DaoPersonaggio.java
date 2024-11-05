package org.prepuzy.dao;



import java.util.List;

import org.prepuzy.model.OggettiMercante;
import org.prepuzy.model.Personaggio;
import org.prepuzy.model.Tecniche;

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
	void aggiornaPrezzi(List<OggettiMercante> oggettiDaAggiornare);
	void insertOggettoMercante(OggettiMercante o);
	void insertTecniche(Tecniche t);
	void updateTecniche(Tecniche t);
	boolean deleteTecniche(long id);
	Tecniche selectTecnicaById(long id);
	List<Tecniche> listaTecniche();
	List<Tecniche> listaTecnicheByPersonaggioId(long id);
}
