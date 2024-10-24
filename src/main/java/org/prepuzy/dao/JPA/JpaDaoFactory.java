package org.prepuzy.dao.JPA;

import org.prepuzy.dao.DaoCapitolo;
import org.prepuzy.dao.DaoCiurma;
import org.prepuzy.dao.DaoEquipaggiamento;
import org.prepuzy.dao.DaoFactory;
import org.prepuzy.dao.DaoFrutto;
import org.prepuzy.dao.DaoInventario;
import org.prepuzy.dao.DaoMappa;
import org.prepuzy.dao.DaoNave;
import org.prepuzy.dao.DaoOggetto;
import org.prepuzy.dao.DaoPersonaggio;
import org.prepuzy.dao.DaoProfessione;
import org.prepuzy.dao.DaoQualita;
import org.prepuzy.dao.DaoRazza;
import org.prepuzy.dao.DaoResistenza;
import org.prepuzy.dao.DaoStatusAlterati;
import org.prepuzy.dao.DaoTipo;
import org.prepuzy.dao.DaoTipologia;
import org.prepuzy.dao.DaoUtenti;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class JpaDaoFactory extends DaoFactory{
	public static EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("DndProject").createEntityManager();
	}

	@Override
	public DaoUtenti getJpaDaoUtenti() {
		return JpaDaoUtenti.getInstance();
	}

	@Override
	public DaoCapitolo getJpaDaoCapitolo() {
		return JpaDaoCapitolo.getInstance();
	}

	@Override
	public DaoCiurma getJpaDaoCiurma() {
		return JpaDaoCiurma.getInstance();
	}

	@Override
	public DaoEquipaggiamento getJpaDaoEquipaggiamento() {
		return JpaDaoEquipaggiamento.getInstance();
	}

	@Override
	public DaoFrutto getJpaDaoFrutto() {
		return JpaDaoFrutto.getInstance();
	}

	@Override
	public DaoInventario getJpaDaoInventario() {
		return JpaDaoInventario.getInstance();
	}

	@Override
	public DaoMappa getJpaDaoMappa() {
		return JpaDaoMappa.getInstance();
	}

	@Override
	public DaoNave getJpaDaoNave() {
		return JpaDaoNave.getInstance();
	}

	@Override
	public DaoOggetto getJpaDaoOggetto() {
		return JpaDaoOggetto.getInstance();
	}

	@Override
	public DaoPersonaggio getJpaDaoPersonaggio() {
		return JpaDaoPersonaggio.getInstance();
	}

	@Override
	public DaoProfessione getJpaDaoProfessione() {
		return JpaDaoProfessione.getInstance();
	}

	@Override
	public DaoQualita getJpaDaoQualita() {
		return JpaDaoQualita.getInstance();
	}

	@Override
	public DaoRazza getJpaDaoRazza() {
		return JpaDaoRazza.getInstance();
	}

	@Override
	public DaoResistenza getJpaDaoResistenza() {
		return JpaDaoResistenza.getInstance();
	}

	@Override
	public DaoStatusAlterati getJpaDaoStatusAlterati() {
		return JpaDaoStatusAlterati.getInstance();
	}

	@Override
	public DaoTipo getJpaDaoTipo() {
		return JpaDaoTipo.getInstance();
	}

	@Override
	public DaoTipologia getJpaDaoTipologia() {
		return JpaDaoTipologia.getInstance();
	}
	
}
