package org.prepuzy.model;

import java.util.List;
import java.util.Objects;

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
    @OneToOne
    private Personaggio personaggio;
    @OneToOne
    private Nave nave;

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

    public Nave getNave() {
	return nave;
    }

    public void setNave(Nave nave) {
	this.nave = nave;
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
	Equipaggiamento other = (Equipaggiamento) obj;
	return id == other.id;
    }

}
