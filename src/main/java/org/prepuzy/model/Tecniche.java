package org.prepuzy.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;

@Entity
public class Tecniche {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String descrizione;
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "personaggio_tecniche", joinColumns = @JoinColumn(name = "tecniche_id"), inverseJoinColumns = @JoinColumn(name = "personaggio_id"))
    private List<Personaggio> visibileAPersonaggio;
	
	public Tecniche() {
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
	public List<Personaggio> getVisibileAPersonaggio() {
		return visibileAPersonaggio;
	}
	public void setVisibileAPersonaggio(List<Personaggio> visibileAPersonaggio) {
		this.visibileAPersonaggio = visibileAPersonaggio;
	}
	
	
}
