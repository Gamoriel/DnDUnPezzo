package org.prepuzy.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Nave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String descrizione;
	@OneToOne( fetch = FetchType.EAGER)
	private Ciurma ciurma;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Inventario deposito;
	@OneToMany(mappedBy = "nave")
	private List<Personaggio> personaggi;
	private int hp;
	private boolean isVisibleToAll;
	
	public Nave() {
		super();
		this.deposito = new Inventario();
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Ciurma getCiurma() {
		return ciurma;
	}

	public void setCiurma(Ciurma ciurma) {
		this.ciurma = ciurma;
	}

	public Inventario getDeposito() {
		return deposito;
	}

	public void setDeposito(Inventario deposito) {
		this.deposito = deposito;
	}

	public List<Personaggio> getPersonaggi() {
		return personaggi;
	}

	public void setPersonaggi(List<Personaggio> personaggi) {
		this.personaggi = personaggi;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public boolean isVisibleToAll() {
		return isVisibleToAll;
	}

	public void setVisibleToAll(boolean isVisibleToAll) {
		this.isVisibleToAll = isVisibleToAll;
	}
	
}
