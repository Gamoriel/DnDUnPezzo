package org.prepuzy.model;

import java.util.List;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.OneToOne;

@Entity
public class Personaggio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome, soprannome;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String descrizione;
	private List<String> taglia, urlImmagine;
    @OneToMany(mappedBy = "mercante", cascade = CascadeType.ALL)
    private List<OggettiMercante> oggettiMercante;
	@ManyToOne (fetch = FetchType.EAGER)
	private Razza razza;
    @ManyToMany
    @JoinTable(
        name = "personaggio_professione",
        joinColumns = @JoinColumn(name = "personaggio_id"),
        inverseJoinColumns = @JoinColumn(name = "professione_id")
    )
	private List<Professione> professioni;
	@OneToOne(mappedBy = "personaggio", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Inventario inventario;
	@OneToOne(mappedBy = "personaggio", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Equipaggiamento equip;
	@ManyToOne (fetch = FetchType.EAGER)
	private Ciurma ciurma;
	@ManyToOne (fetch = FetchType.EAGER)
	private Nave nave;
	@OneToOne(mappedBy = "personaggio", fetch = FetchType.EAGER)
	private Frutto frutto;
    @ManyToMany
    @JoinTable(
        name = "personaggio_mappa",
        joinColumns = @JoinColumn(name = "personaggio_id"),
        inverseJoinColumns = @JoinColumn(name = "mappa_id")
    )
    private List<Mappa> mappe;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    @ManyToMany(mappedBy = "visibileAPersonaggio", fetch = FetchType.EAGER)
    private List<AbilitaFrutto> abilitaFruttoVisibileAPersonaggio;
    @ManyToMany(mappedBy = "visibileAPersonaggio", fetch = FetchType.EAGER)
    private List<AbilitaProfessione> abilitaProfessioneVisibileAPersonaggio;
    @ManyToMany(mappedBy = "visibileAPersonaggio", fetch = FetchType.EAGER)
    private List<Tecniche> tecnichePersonaggio;
    private int forza,destrezza,costituzione,intelligenza,saggezza,carisma,hp,classeArmatura;
    private boolean isVisibleToAll, isMercante;
	
	public Personaggio() {
		super();
	}

	public List<OggettiMercante> getOggettiMercante() {
		return oggettiMercante;
	}

	public void setOggettiMercante(List<OggettiMercante> oggettiMercante) {
		this.oggettiMercante = oggettiMercante;
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

	public String getSoprannome() {
		return soprannome;
	}

	public void setSoprannome(String soprannome) {
		this.soprannome = soprannome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Razza getRazza() {
		return razza;
	}

	public void setRazza(Razza razza) {
		this.razza = razza;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public Equipaggiamento getEquip() {
		return equip;
	}

	public void setEquip(Equipaggiamento equip) {
		this.equip = equip;
	}

	public Ciurma getCiurma() {
		return ciurma;
	}

	public void setCiurma(Ciurma ciurma) {
		this.ciurma = ciurma;
	}

	public Nave getNave() {
		return nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}

	public Frutto getFrutto() {
		return frutto;
	}

	public void setFrutto(Frutto frutto) {
		this.frutto = frutto;
	}

	public List<Professione> getProfessioni() {
		return professioni;
	}

	public void setProfessioni(List<Professione> professioni) {
		this.professioni = professioni;
	}

	public List<Mappa> getMappe() {
		return mappe;
	}

	public void setMappe(List<Mappa> mappe) {
		this.mappe = mappe;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
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

	public int getClasseArmatura() {
		return classeArmatura;
	}

	public void setClasseArmatura(int classeArmatura) {
		this.classeArmatura = classeArmatura;
	}

	public boolean isMercante() {
		return isMercante;
	}

	public void setMercante(boolean isMercante) {
		this.isMercante = isMercante;
	}

	public List<AbilitaFrutto> getAbilitaFruttoVisibileAPersonaggio() {
		return abilitaFruttoVisibileAPersonaggio;
	}

	public void setAbilitaFruttoVisibileAPersonaggio(List<AbilitaFrutto> abilitaFruttoVisibileAPersonaggio) {
		this.abilitaFruttoVisibileAPersonaggio = abilitaFruttoVisibileAPersonaggio;
	}

	public List<AbilitaProfessione> getAbilitaProfessioneVisibileAPersonaggio() {
		return abilitaProfessioneVisibileAPersonaggio;
	}

	public void setAbilitaProfessioneVisibileAPersonaggio(List<AbilitaProfessione> abilitaProfessioneVisibileAPersonaggio) {
		this.abilitaProfessioneVisibileAPersonaggio = abilitaProfessioneVisibileAPersonaggio;
	}

	public List<Tecniche> getTecnichePersonaggio() {
		return tecnichePersonaggio;
	}

	public void setTecnichePersonaggio(List<Tecniche> tecnichePersonaggio) {
		this.tecnichePersonaggio = tecnichePersonaggio;
	}

	public List<String> getTaglia() {
		return taglia;
	}

	public void setTaglia(List<String> taglia) {
		this.taglia = taglia;
	}

	public List<String> getUrlImmagine() {
		return urlImmagine;
	}

	public void setUrlImmagine(List<String> urlImmagine) {
		this.urlImmagine = urlImmagine;
	}	
}
