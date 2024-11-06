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
	private String nome, soprannome, urlImmagine;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String descrizione;
	private List<Integer> taglia;
    @OneToMany(mappedBy = "mercante", cascade = CascadeType.ALL)
    private List<OggettiMercante> oggettiMercante;
	@ManyToOne (fetch = FetchType.EAGER)
	private Razza razza;
	@ManyToOne
	private Professione professione;
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
	@ManyToOne
	private Mappa mappa;
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

	public List<Integer> getTaglia() {
		return taglia;
	}

	public void setTaglia(List<Integer> taglia) {
		this.taglia = taglia;
	}

	public Razza getRazza() {
		return razza;
	}

	public void setRazza(Razza razza) {
		this.razza = razza;
	}

	public Professione getProfessione() {
		return professione;
	}

	public void setProfessione(Professione professione) {
		this.professione = professione;
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

	public Mappa getMappa() {
		return mappa;
	}

	public void setMappa(Mappa mappa) {
		this.mappa = mappa;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public String getUrlImmagine() {
		return urlImmagine;
	}

	public void setUrlImmagine(String urlImmagine) {
		this.urlImmagine = urlImmagine;
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
	
}
