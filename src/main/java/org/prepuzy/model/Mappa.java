package org.prepuzy.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Mappa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String immagine, nome;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String descrizione;
    @OneToMany(mappedBy = "mappaPadre", fetch = FetchType.EAGER)
    private List<Mappa> mappe;
    @ManyToOne
    @JoinColumn(name = "mappa_padre_id")
    private Mappa mappaPadre;
    @ManyToMany(mappedBy = "mappe")
    private List<Personaggio> personaggi;
    @OneToOne(mappedBy = "mappa", fetch = FetchType.EAGER)
    private Capitolo capitolo;
    private boolean isVisibleToAll;

    public Mappa() {
	super();
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getImmagine() {
	return immagine;
    }

    public void setImmagine(String immagine) {
	this.immagine = immagine;
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

    public List<Mappa> getMappe() {
	return mappe;
    }

    public void setMappe(List<Mappa> mappe) {
	this.mappe = mappe;
    }

    public List<Personaggio> getPersonaggi() {
	return personaggi;
    }

    public void setPersonaggi(List<Personaggio> personaggi) {
	this.personaggi = personaggi;
    }

    public Mappa getMappaPadre() {
	return mappaPadre;
    }

    public void setMappaPadre(Mappa mappaPadre) {
	this.mappaPadre = mappaPadre;
    }

    public Capitolo getCapitolo() {
	return capitolo;
    }

    public void setCapitolo(Capitolo capitolo) {
	this.capitolo = capitolo;
    }

    public boolean isVisibleToAll() {
	return isVisibleToAll;
    }

    public void setVisibleToAll(boolean isVisibleToAll) {
	this.isVisibleToAll = isVisibleToAll;
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
	Mappa other = (Mappa) obj;
	return id == other.id;
    }

}
