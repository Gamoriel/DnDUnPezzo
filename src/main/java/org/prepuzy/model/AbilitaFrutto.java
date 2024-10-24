package org.prepuzy.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class AbilitaFrutto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome,descrizione;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "personaggio_abilita_frutto", joinColumns = @JoinColumn(name = "abilita_id"), inverseJoinColumns = @JoinColumn(name = "personaggio_id"))
    private List<Personaggio> visibileAPersonaggio;
    @ManyToOne(fetch = FetchType.LAZY)
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
    
    
}
