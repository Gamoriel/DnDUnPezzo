package org.prepuzy.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Qualita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String qualita;
	@OneToMany(mappedBy = "qualita")
	private List<Frutto> frutto;
	
	public Qualita() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getQualita() {
		return qualita;
	}
	public void setQualita(String qualita) {
		this.qualita = qualita;
	}
	public List<Frutto> getFrutto() {
		return frutto;
	}
	public void setFrutto(List<Frutto> frutto) {
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
	    Qualita other = (Qualita) obj;
	    return id == other.id;
	}
	
}
