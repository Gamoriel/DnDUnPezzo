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
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class AbilitaProfessione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String descrizione;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "personaggio_abilita_professione", joinColumns = @JoinColumn(name = "abilita_id"), inverseJoinColumns = @JoinColumn(name = "personaggio_id"))
    private List<Personaggio> visibileAPersonaggio;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professione_id")
    private Professione professione;
    
	public AbilitaProfessione() {
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
	public Professione getProfessione() {
		return professione;
	}
	public void setProfessione(Professione professione) {
		this.professione = professione;
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
	    AbilitaProfessione other = (AbilitaProfessione) obj;
	    return id == other.id;
	}
    
    
}
