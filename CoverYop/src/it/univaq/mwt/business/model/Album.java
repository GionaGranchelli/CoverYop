package it.univaq.mwt.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Access;

import static javax.persistence.AccessType.PROPERTY;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

@Entity
@Access(PROPERTY)
public class Album implements Serializable {
	
	
	private int id;
	
	private String nome;
	
	private float durata;
	
	private int anno;
	
	
	private Set<Canzone> canzoni = new HashSet<Canzone>();
	
	
	private Gruppo gruppo;
	
	private static final long serialVersionUID = 1L;

	public Album() {
		super();
	}

	public Album(int id, String nome, float durata, int anno,
			Set<Canzone> canzoni, Gruppo gruppo) {
		super();
		this.id = id;
		this.nome = nome;
		this.durata = durata;
		this.anno = anno;
		this.canzoni = canzoni;
		this.gruppo = gruppo;
	}
	
	public Album(String nome, float durata, int anno,
			Set<Canzone> canzoni, Gruppo gruppo) {
		super();
		this.nome = nome;
		this.durata = durata;
		this.anno = anno;
		this.canzoni = canzoni;
		this.gruppo = gruppo;
	}

	public Album(int id, String nome, float durata, int anno) {
		super();
		this.id = id;
		this.nome = nome;
		this.durata = durata;
		this.anno = anno;
	}
	
	public Album(String nome, float durata, int anno) {
		super();
		this.nome = nome;
		this.durata = durata;
		this.anno = anno;
	}
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@GeneratedValue(generator="AlbSeq")
    @SequenceGenerator(name="AlbSeq",sequenceName="ALBUM_SEQ",allocationSize=1)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getDurata() {
		return durata;
	}

	public void setDurata(float durata) {
		this.durata = durata;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	@OneToMany(fetch=FetchType.LAZY,cascade={PERSIST, REFRESH},mappedBy="album")
	public Set<Canzone> getCanzoni() {
		return canzoni;
	}

	public void setCanzoni(Set<Canzone> canzoni) {
		this.canzoni = canzoni;
	}

	@ManyToOne
	public Gruppo getGruppo() {
		return gruppo;
	}

	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}

	public void addCanzone(Canzone c){
		canzoni.add(c);
	}
	
	
	
}
