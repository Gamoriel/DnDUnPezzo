package org.prepuzy.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Inventario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int berry;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "inventario_oggetto", joinColumns = @JoinColumn(name = "inventario_id"), inverseJoinColumns = @JoinColumn(name = "oggetto_id"))
	private List<Oggetto> oggetti;
	@OneToMany (fetch = FetchType.EAGER)
	private List<Frutto> frutti;
    @OneToOne
    private Personaggio personaggio;
    @OneToOne 
    private Nave nave;
    private long maxCapienza = 40;
	
	public Inventario() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getBerry() {
		return berry;
	}

	public void setBerry(int berry) {
		this.berry = berry;
	}

	public List<Oggetto> getOggetti() {
		return oggetti;
	}

	public void setOggetti(List<Oggetto> oggetti) {
		this.oggetti = oggetti;
	}

	public List<Frutto> getFrutti() {
		return frutti;
	}

	public void setFrutti(List<Frutto> frutti) {
		this.frutti = frutti;
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

	public long getMaxCapienza() {
		return maxCapienza;
	}
}
