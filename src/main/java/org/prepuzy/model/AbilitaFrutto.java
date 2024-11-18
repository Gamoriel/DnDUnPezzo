package org.prepuzy.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class AbilitaFrutto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String descrizione;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "personaggio_abilita_frutto", joinColumns = @JoinColumn(name = "abilita_id"), inverseJoinColumns = @JoinColumn(name = "personaggio_id"))
    private List<Personaggio> visibileAPersonaggio;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "frutto_id")
    private Frutto frutto;
    
	public AbilitaFrutto() {
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
	public Frutto getFrutto() {
		return frutto;
	}
	public void setFrutto(Frutto frutto) {
		this.frutto = frutto;
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
	    AbilitaFrutto other = (AbilitaFrutto) obj;
	    return id == other.id;
	}
    
    
}
