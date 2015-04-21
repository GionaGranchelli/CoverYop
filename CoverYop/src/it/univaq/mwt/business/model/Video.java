package it.univaq.mwt.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

import java.util.Collection;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Access;

import static javax.persistence.TemporalType.DATE;
import static javax.persistence.AccessType.PROPERTY;

@Entity
@Access(PROPERTY)
public class Video implements Serializable{


	private int id;

	private String titolo;

	private Date data;
	
	private String tag;

	private String url;
	
	
	private Utente utente; 

	private static final long serialVersionUID = 1L;
	
	public Video() {
		super();
	}

	public Video(int id, String titolo, Date data, String tag, String url,
			Utente utente) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.data = data;
		this.tag = tag;
		this.url = url;
		this.utente = utente;
	}
	
	public Video(String titolo, Date data, String tag, String url,
			Gruppo gruppo) {
		super();
		this.titolo = titolo;
		this.data = data;
		this.tag = tag;
		this.url = url;
		this.utente= utente;
	}

	public Video(int id, String titolo, Date data, String tag, String url) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.data = data;
		this.tag = tag;
		this.url = url;
	}
	
	public Video(String titolo, Date data, String tag, String url) {
		super();
		this.titolo = titolo;
		this.data = data;
		this.tag = tag;
		this.url = url;
	}
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@GeneratedValue(generator="VidSeq")
    @SequenceGenerator(name="VidSeq",sequenceName="VIDEO_SEQ",allocationSize=1)
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
	@Temporal(DATE)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@ManyToOne(fetch = LAZY)
	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}



	
}
