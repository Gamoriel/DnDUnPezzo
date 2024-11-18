package org.prepuzy.model;

import java.util.List;
import java.util.Objects;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username, password;
	@OneToMany(mappedBy = "utente", fetch = FetchType.EAGER)
    private List<Personaggio> personaggi;
	private Role role;
	
	public Utente() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Personaggio> getPersonaggi() {
		return personaggi;
	}
	public void setPersonaggi(List<Personaggio> personaggi) {
		this.personaggi = personaggi;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
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
	    Utente other = (Utente) obj;
	    return id == other.id;
	}
	
}
