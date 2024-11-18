package org.prepuzy.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Nave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome, immagine;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String descrizione;
    @OneToOne(fetch = FetchType.EAGER)
    private Ciurma ciurma;
    @OneToOne(mappedBy = "nave", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Inventario deposito;
    @OneToOne(mappedBy = "nave", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Equipaggiamento equip;
    @OneToMany(mappedBy = "nave")
    private List<Personaggio> personaggi;
    private int hp, classeArmatura;
    private boolean isVisibleToAll;

    public Nave() {
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

    public Ciurma getCiurma() {
	return ciurma;
    }

    public void setCiurma(Ciurma ciurma) {
	this.ciurma = ciurma;
    }

    public Inventario getDeposito() {
	return deposito;
    }

    public void setDeposito(Inventario deposito) {
	this.deposito = deposito;
    }

    public List<Personaggio> getPersonaggi() {
	return personaggi;
    }

    public void setPersonaggi(List<Personaggio> personaggi) {
	this.personaggi = personaggi;
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

    public Equipaggiamento getEquip() {
	return equip;
    }

    public void setEquip(Equipaggiamento equip) {
	this.equip = equip;
    }

    public int getClasseArmatura() {
	return classeArmatura;
    }

    public void setClasseArmatura(int classeArmatura) {
	this.classeArmatura = classeArmatura;
    }

    public String getImmagine() {
	return immagine;
    }

    public void setImmagine(String immagine) {
	this.immagine = immagine;
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
	Nave other = (Nave) obj;
	return id == other.id;
    }

}
