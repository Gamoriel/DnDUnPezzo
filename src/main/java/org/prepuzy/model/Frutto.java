package org.prepuzy.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Frutto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String descrizione;
	private int prezzo;
	@OneToMany
	private List<StatusAlterati> status;
	@OneToOne(fetch = FetchType.EAGER)
	@ManyToOne
	private Tipo tipo;
	@ManyToOne
	private Qualita qualita;
	@OneToMany
	private List<Resistenza> resistenza;
	@OneToOne
	private Personaggio personaggio;
	@OneToMany(mappedBy = "frutto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AbilitaFrutto> abilitaFrutto;
	private int forza,destrezza,costituzione,intelligenza,saggezza,carisma,hp;
	private boolean isVisibleToAll;
	
	public Frutto() {
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

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public List<StatusAlterati> getStatus() {
		return status;
	}

	public void setStatus(List<StatusAlterati> status) {
		this.status = status;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Qualita getQualita() {
		return qualita;
	}

	public void setQualita(Qualita qualita) {
		this.qualita = qualita;
	}

	public List<Resistenza> getResistenza() {
		return resistenza;
	}

	public void setResistenza(List<Resistenza> resistenza) {
		this.resistenza = resistenza;
	}

	public Personaggio getPersonaggio() {
		return personaggio;
	}

	public void setPersonaggio(Personaggio personaggio) {
		this.personaggio = personaggio;
	}

	public int getForza() {
		return forza;
	}

	public void setForza(int forza) {
		this.forza = forza;
	}

	public int getDestrezza() {
		return destrezza;
	}

	public void setDestrezza(int destrezza) {
		this.destrezza = destrezza;
	}

	public int getCostituzione() {
		return costituzione;
	}

	public void setCostituzione(int costituzione) {
		this.costituzione = costituzione;
	}

	public int getIntelligenza() {
		return intelligenza;
	}

	public void setIntelligenza(int intelligenza) {
		this.intelligenza = intelligenza;
	}

	public int getSaggezza() {
		return saggezza;
	}

	public void setSaggezza(int saggezza) {
		this.saggezza = saggezza;
	}

	public int getCarisma() {
		return carisma;
	}

	public void setCarisma(int carisma) {
		this.carisma = carisma;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public boolean isVisibleToAll() {
		return isVisibleToAll;
	}

	public void setVisibleToAll(boolean isVisibleToAll) {
		this.isVisibleToAll = isVisibleToAll;
	}

	public List<AbilitaFrutto> getAbilita() {
		return abilitaFrutto;
	}

	public void setAbilita(List<AbilitaFrutto> abilitaFrutto) {
		this.abilitaFrutto = abilitaFrutto;
	}
	
	
}
