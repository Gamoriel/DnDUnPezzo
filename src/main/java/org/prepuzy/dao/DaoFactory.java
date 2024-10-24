package org.prepuzy.dao;

import org.prepuzy.dao.JPA.JpaDaoFactory;

public abstract class DaoFactory {
	private static DaoFactory instance;
	public static DaoFactory getInstance(String database) {
		
		if (instance == null) {
			switch (database) {
				case "JPA": instance = new JpaDaoFactory();
				break;
			}
		}
		return instance;
	}
	
	public abstract DaoUtenti getJpaDaoUtenti();
	public abstract DaoCapitolo getJpaDaoCapitolo();
	public abstract DaoCiurma getJpaDaoCiurma();
	public abstract DaoEquipaggiamento getJpaDaoEquipaggiamento();
	public abstract DaoFrutto getJpaDaoFrutto();
	public abstract DaoInventario getJpaDaoInventario();
	public abstract DaoMappa getJpaDaoMappa();
	public abstract DaoNave getJpaDaoNave();
	public abstract DaoOggetto getJpaDaoOggetto();
	public abstract DaoPersonaggio getJpaDaoPersonaggio();
	public abstract DaoProfessione getJpaDaoProfessione();
	public abstract DaoQualita getJpaDaoQualita();
	public abstract DaoRazza getJpaDaoRazza();
	public abstract DaoResistenza getJpaDaoResistenza();
	public abstract DaoStatusAlterati getJpaDaoStatusAlterati();
	public abstract DaoTipo getJpaDaoTipo();
	public abstract DaoTipologia getJpaDaoTipologia();
}
