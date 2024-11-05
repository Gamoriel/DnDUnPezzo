package org.prepuzy.model;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Equipaggiamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToMany(mappedBy = "equipaggiamento", fetch = FetchType.EAGER)
	private List<Oggetto> oggetti;
	@OneToOne( fetch = FetchType.EAGER)
	private Personaggio personaggio;
	
	public Equipaggiamento() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Oggetto> getOggetti() {
		return oggetti;
	}

	public void setOggetti(List<Oggetto> oggetti) {
		this.oggetti = oggetti;
	}

	public Personaggio getPersonaggio() {
		return personaggio;
	}

	public void setPersonaggio(Personaggio personaggio) {
		this.personaggio = personaggio;
	}
}
