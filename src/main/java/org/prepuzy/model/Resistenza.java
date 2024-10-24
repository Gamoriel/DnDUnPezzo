package org.prepuzy.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Resistenza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome, descrizione;
    @ManyToOne
    @JoinColumn(name = "frutto_id")
	private Frutto frutto;
    @ManyToMany(mappedBy = "resistenze")
    private List<Oggetto> oggetto;
    
	public Resistenza() {
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
	public Frutto getFrutto() {
		return frutto;
	}
	public void setFrutto(Frutto frutto) {
		this.frutto = frutto;
	}
	public List<Oggetto> getOggetto() {
		return oggetto;
	}
	public void setOggetto(List<Oggetto> oggetto) {
		this.oggetto = oggetto;
	}

}
