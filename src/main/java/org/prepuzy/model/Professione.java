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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Professione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String descrizione;
	@OneToMany(mappedBy = "professione", fetch = FetchType.EAGER)
	private List<Personaggio> personaggi;
	@ManyToMany(mappedBy = "professioni", fetch = FetchType.EAGER)
    private List<Oggetto> oggetto;
	@OneToMany(mappedBy = "professione", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AbilitaProfessione> abilitaProfessione;
    private int forza,destrezza,costituzione,intelligenza,saggezza,carisma,hp;
	
	public Professione() {
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Oggetto> getOggetto() {
		return oggetto;
	}

	public void setOggetto(List<Oggetto> oggetto) {
		this.oggetto = oggetto;
	}

	public List<Personaggio> getPersonaggi() {
		return personaggi;
	}

	public void setPersonaggi(List<Personaggio> personaggi) {
		this.personaggi = personaggi;
	}

	public int getForza() {
		return forza;
	}

	public void setForza(int forza) {
		this.forza = forza;
	}

	public int getDestrezza() {
		return destrezza;
	}

	public void setDestrezza(int destrezza) {
		this.destrezza = destrezza;
	}

	public int getCostituzione() {
		return costituzione;
	}

	public void setCostituzione(int costituzione) {
		this.costituzione = costituzione;
	}

	public int getIntelligenza() {
		return intelligenza;
	}

	public void setIntelligenza(int intelligenza) {
		this.intelligenza = intelligenza;
	}

	public int getSaggezza() {
		return saggezza;
	}

	public void setSaggezza(int saggezza) {
		this.saggezza = saggezza;
	}

	public int getCarisma() {
		return carisma;
	}

	public void setCarisma(int carisma) {
		this.carisma = carisma;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public List<AbilitaProfessione> getAbilitaProfessione() {
		return abilitaProfessione;
	}

	public void setAbilitaProfessione(List<AbilitaProfessione> abilitaProfessione) {
		this.abilitaProfessione = abilitaProfessione;
	}

}
