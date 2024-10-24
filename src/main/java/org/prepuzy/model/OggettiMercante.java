package org.prepuzy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OggettiMercante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Personaggio mercante; 
    @ManyToOne
    private Oggetto oggetto;
    private long prezzo;
    
	public OggettiMercante() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(long prezzo) {
		this.prezzo = prezzo;
	}

	public Personaggio getMercante() {
		return mercante;
	}

	public void setMercante(Personaggio mercante) {
		this.mercante = mercante;
	}

	public Oggetto getOggetto() {
		return oggetto;
	}

	public void setOggetto(Oggetto oggetto) {
		this.oggetto = oggetto;
	}
    
}
