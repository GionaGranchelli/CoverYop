package it.univaq.mwt.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;


import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Access;

import static javax.persistence.AccessType.PROPERTY;

//@Entity
//@Access(PROPERTY)
public class Feedback implements Serializable{


	private int id;

	private int idFeed;
	
	private int idMittente;
	
	private int idDestinatario;
	
	private int voto;
	
	private String descrizione;
	
	private Date data;
	
	
	private Gruppo gruppo;
	
	
	private Locale locale;
	
	private static final long serialVersionUID = 1L;
	
	public Feedback() {
		super();
	}


	public Feedback(int id, int idFeed, int idMittente, int idDestinatario,
			int voto, String descrizione, Date data, Gruppo gruppo,Locale locale
			) {
		super();
		this.id = id;
		this.idFeed = idFeed;
		this.idMittente = idMittente;
		this.idDestinatario = idDestinatario;
		this.voto = voto;
		this.descrizione = descrizione;
		this.data = data;
		this.gruppo = gruppo;
		this.locale = locale;
	}
	
	public Feedback(int idFeed, int idMittente, int idDestinatario,
			int voto, String descrizione, Date data, Gruppo gruppo,
			Locale locale) {
		super();
		this.idFeed = idFeed;
		this.idMittente = idMittente;
		this.idDestinatario = idDestinatario;
		this.voto = voto;
		this.descrizione = descrizione;
		this.data = data;
		this.gruppo = gruppo;
		this.locale = locale;
	}


	public Feedback(int id, int idFeed, int idMittente, int idDestinatario,
			int voto, String descrizione, Date data) {
		super();
		this.id = id;
		this.idFeed = idFeed;
		this.idMittente = idMittente;
		this.idDestinatario = idDestinatario;
		this.voto = voto;
		this.descrizione = descrizione;
		this.data = data;
	}
	
	public Feedback(int idFeed, int idMittente, int idDestinatario,
			int voto, String descrizione, Date data) {
		super();
		this.idFeed = idFeed;
		this.idMittente = idMittente;
		this.idDestinatario = idDestinatario;
		this.voto = voto;
		this.descrizione = descrizione;
		this.data = data;
	}

	//@Id
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdFeed() {
		return idFeed;
	}


	public void setIdFeed(int idFeed) {
		this.idFeed = idFeed;
	}


	public int getIdMittente() {
		return idMittente;
	}


	public void setIdMittente(int idMittente) {
		this.idMittente = idMittente;
	}


	public int getIdDestinatario() {
		return idDestinatario;
	}


	public void setIdDestinatario(int idDestinatario) {
		this.idDestinatario = idDestinatario;
	}


	public int getVoto() {
		return voto;
	}


	public void setVoto(int voto) {
		this.voto = voto;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	//@Temporal(DATE)
	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}

	//@ManyToOne(fetch=FetchType.LAZY)
	public Gruppo getGruppo() {
		return gruppo;
	}


	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}

	//@ManyToOne(fetch=FetchType.LAZY)
	public Locale getLocale() {
		return locale;
	}


	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
