package it.univaq.mwt.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Access;

import static javax.persistence.AccessType.PROPERTY;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

@Entity
@Access(PROPERTY)
public class Canzone implements Serializable{
	
	
	private int id;
	
	private String titolo;
	
	private float durata;
	
	private String url;
	

	private Album album;

	
	private Scaletta scaletta;
	
	private static final long serialVersionUID = 1L;
	
	public Canzone() {
		super();
	}

	public Canzone(int id, String titolo, float durata, String url,
			Album album, Scaletta scaletta) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.durata = durata;
		this.url = url;
		this.album = album;
		this.scaletta = scaletta;
	}
	
	public Canzone(String titolo, float durata, String url,
			Album album, Scaletta scaletta) {
		super();
		this.titolo = titolo;
		this.durata = durata;
		this.url = url;
		this.album = album;
		this.scaletta = scaletta;
	}

	public Canzone(int id, String titolo, float durata, String url) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.durata = durata;
		this.url = url;
	}
	
	public Canzone(String titolo, float durata, String url) {
		super();
		this.titolo = titolo;
		this.durata = durata;
		this.url = url;
	}
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@GeneratedValue(generator="CanSeq")
    @SequenceGenerator(name="CanSeq",sequenceName="CANZONE_SEQ",allocationSize=1)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public float getDurata() {
		return durata;
	}

	public void setDurata(float durata) {
		this.durata = durata;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@ManyToOne(fetch=FetchType.LAZY,cascade={PERSIST, REFRESH})
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@ManyToOne(fetch=FetchType.LAZY,cascade={PERSIST, REFRESH})
	public Scaletta getScaletta() {
		return scaletta;
	}

	public void setScaletta(Scaletta scaletta) {
		this.scaletta = scaletta;
	}

	
}
