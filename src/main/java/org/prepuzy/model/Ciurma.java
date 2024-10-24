package org.prepuzy.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Ciurma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome, jollyRoger, descrizione;
	@OneToMany(mappedBy = "ciurma", fetch = FetchType.EAGER)
	private List<Personaggio> personaggi;
	@OneToMany(mappedBy = "ciurmaPadre",fetch = FetchType.EAGER)
	private List<Ciurma> ciurme;
	@ManyToOne
	@JoinColumn(name = "ciurma_padre_id")
	private Ciurma ciurmaPadre;
	@OneToOne(mappedBy = "ciurma", fetch = FetchType.EAGER)
	private Nave nave;
	private boolean isVisibleToAll;
	
	public Ciurma() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getJollyRoger() {
		return jollyRoger;
	}
	public void setJollyRoger(String jollyRoger) {
		this.jollyRoger = jollyRoger;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public List<Personaggio> getPersonaggi() {
		return personaggi;
	}
	public void setPersonaggi(List<Personaggio> personaggi) {
		this.personaggi = personaggi;
	}
	public List<Ciurma> getCiurme() {
		return ciurme;
	}
	public void setCiurme(List<Ciurma> ciurme) {
		this.ciurme = ciurme;
	}
	public Nave getNave() {
		return nave;
	}
	public void setNave(Nave nave) {
		this.nave = nave;
	}
	public Ciurma getCiurmaPadre() {
		return ciurmaPadre;
	}
	public void setCiurmaPadre(Ciurma ciurmaPadre) {
		this.ciurmaPadre = ciurmaPadre;
	}
	public boolean isVisibleToAll() {
		return isVisibleToAll;
	}
	public void setVisibleToAll(boolean isVisibleToAll) {
		this.isVisibleToAll = isVisibleToAll;
	}
}
