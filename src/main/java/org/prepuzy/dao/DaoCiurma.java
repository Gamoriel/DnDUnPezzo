package org.prepuzy.dao;

import java.util.List;

import org.prepuzy.model.Ciurma;
import org.prepuzy.model.Personaggio;

public interface DaoCiurma {
	void insert(Ciurma c);
	List<Ciurma> listaCiurme();
	List<Ciurma> filtroSelectAll();
	Ciurma selectById(long id);
	List<Personaggio> membriCiurma(long id);
	void delete(long id);
	void update(Ciurma c);
	void rimuovipersonaggioDaCiurma(long idciurma, long idpersonaggio);
	void aggiungiPersonaggioACiurma(long idciurma, long idpersonaggio);
}