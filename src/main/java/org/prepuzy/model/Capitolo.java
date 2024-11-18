package org.prepuzy.model;


import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

@Entity
public class Capitolo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String titolo;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String testo;
    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "mappa_id")
	private Mappa mappa;
    private boolean isVisibleToAll;
	
	public Capitolo() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public Mappa getMappa() {
		return mappa;
	}
	public void setMappa(Mappa mappa) {
		this.mappa = mappa;
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
	    Capitolo other = (Capitolo) obj;
	    return id == other.id;
	}
	
}
