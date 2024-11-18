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
import jakarta.persistence.OneToMany;

@Entity
public class Oggetto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String descrizione;
	@ManyToMany( fetch = FetchType.EAGER)
	@JoinTable(name = "oggetto_resistenza",joinColumns = @JoinColumn(name = "oggetto_id"),inverseJoinColumns = @JoinColumn(name = "resistenza_id"))
	private List<Resistenza> resistenze;
    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(name = "oggetto_razza",joinColumns = @JoinColumn(name = "oggetto_id"),inverseJoinColumns = @JoinColumn(name = "razza_id"))
	private List<Razza> razze;
    @ManyToMany( fetch = FetchType.EAGER)
	@JoinTable(name = "oggetto_professione",joinColumns = @JoinColumn(name = "oggetto_id"),inverseJoinColumns = @JoinColumn(name = "professione_id"))
	private List<Professione> professioni;
    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(name = "oggetto_status",joinColumns = @JoinColumn(name = "oggetto_id"),inverseJoinColumns = @JoinColumn(name = "status_id"))
	private List<StatusAlterati> status;
    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(name = "oggetto_frutto",joinColumns = @JoinColumn(name = "oggetto_id"),inverseJoinColumns = @JoinColumn(name = "frutto_id"))
    private List<Frutto> frutti;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "tipologia_id")
	private Tipologia tipologia;
    @OneToMany(mappedBy = "oggetto")
    private List<OggettiMercante> oggettiMercante;
    @ManyToOne
    @JoinColumn(name = "equipaggiamento_id")
    private Equipaggiamento equipaggiamento;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "oggetti")
    private List<Inventario> inventari;
    private int forza,destrezza,costituzione,intelligenza,saggezza,carisma,hp,prezzo,peso,classeArmatura;
    private boolean isVisibleToAll;
    
	public Oggetto() {
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

	public List<Resistenza> getResistenze() {
		return resistenze;
	}

	public void setResistenze(List<Resistenza> resistenze) {
		this.resistenze = resistenze;
	}

	public List<Razza> getRazze() {
		return razze;
	}

	public void setRazze(List<Razza> razze) {
		this.razze = razze;
	}

	public List<Professione> getProfessioni() {
		return professioni;
	}

	public void setProfessioni(List<Professione> professioni) {
		this.professioni = professioni;
	}

	public List<StatusAlterati> getStatus() {
		return status;
	}

	public void setStatus(List<StatusAlterati> status) {
		this.status = status;
	}

	public Tipologia getTipologia() {
		return tipologia;
	}

	public void setTipologia(Tipologia tipologia) {
		this.tipologia = tipologia;
	}

	public Equipaggiamento getEquipaggiamento() {
		return equipaggiamento;
	}

	public void setEquipaggiamento(Equipaggiamento equipaggiamento) {
		this.equipaggiamento = equipaggiamento;
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

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public boolean isVisibleToAll() {
		return isVisibleToAll;
	}

	public void setVisibleToAll(boolean isVisibleToAll) {
		this.isVisibleToAll = isVisibleToAll;
	}

	public List<OggettiMercante> getOggettiMercante() {
		return oggettiMercante;
	}

	public void setOggettiMercante(List<OggettiMercante> oggettiMercante) {
		this.oggettiMercante = oggettiMercante;
	}

	public List<Inventario> getInventari() {
		return inventari;
	}

	public void setInventari(List<Inventario> inventari) {
		this.inventari = inventari;
	}
	
	public int getClasseArmatura() {
		return classeArmatura;
	}

	public void setClasseArmatura(int classeArmatura) {
		this.classeArmatura = classeArmatura;
	}

	public List<Frutto> getFrutti() {
		return frutti;
	}

	public void setFrutti(List<Frutto> frutti) {
		this.frutti = frutti;
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
	    Oggetto other = (Oggetto) obj;
	    return id == other.id;
	}
}
