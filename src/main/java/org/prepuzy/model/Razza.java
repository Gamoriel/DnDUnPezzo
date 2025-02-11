package org.prepuzy.model;

import java.util.List;
import java.util.Objects;

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
public class Razza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String descrizione;
    @OneToMany(mappedBy = "razza", fetch = FetchType.EAGER)
    private List<Personaggio> personaggi;
    @ManyToMany(mappedBy = "razze",  fetch = FetchType.EAGER)
    private List<Oggetto> oggetto;

    public Razza() {
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

    public List<Personaggio> getPersonaggi() {
	return personaggi;
    }

    public void setPersonaggi(List<Personaggio> personaggi) {
	this.personaggi = personaggi;
    }

    public List<Oggetto> getOggetto() {
	return oggetto;
    }

    public void setOggetto(List<Oggetto> oggetto) {
	this.oggetto = oggetto;
    }

    @Override
    public int hashCode() {
	return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Razza other = (Razza) obj;
	return id == other.id;
    }

}
