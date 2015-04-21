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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Access;

import static javax.persistence.AccessType.PROPERTY;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

@Entity
@Access(PROPERTY)
public class Evento implements Serializable{
	

	private int id;
	
	private Locale locale;
	
	private String data;
	
	private String orarioInizio;
	
	private String orarioFine;
	
	private String nome;
	
	private String luogo;
	
	private float prezzo;
	
	private String locandina;
	
	private String descrizione;
	
	private int status;
	
	private Set<Gruppo> gruppi = new HashSet<Gruppo>();
	
	
	private Tour tour;
	
	
	private TipologiaEvento tipologia_Eventi;
	
	private static final long serialVersionUID = 1L;
	
	
	public Evento() {
		super();
	}
	public Evento(int id){
		this.id = id;
	}

	public Evento(int id, Locale locale, String data, String orarioInizio,
			String orarioFine, String nome, String luogo, float prezzo,
			String locandina, String descrizione, Set<Gruppo> gruppi,
			Tour tour, TipologiaEvento tipologia_Eventi) {
		super();
		this.id = id;
		this.locale = locale;
		this.data = data;
		this.orarioInizio = orarioInizio;
		this.orarioFine = orarioFine;
		this.nome = nome;
		this.luogo = luogo;
		this.prezzo = prezzo;
		this.locandina = locandina;
		this.descrizione = descrizione;
		this.gruppi = gruppi;
		this.tour = tour;
		this.tipologia_Eventi = tipologia_Eventi;
	}
	
	public Evento(Locale locale, String data, String orarioInizio,
			String orarioFine, String nome, String luogo, float prezzo,
			String locandina, String descrizione, Set<Gruppo> gruppi,
			Tour tour, TipologiaEvento tipologia_Eventi) {
		super();
		this.locale = locale;
		this.data = data;
		this.orarioInizio = orarioInizio;
		this.orarioFine = orarioFine;
		this.nome = nome;
		this.luogo = luogo;
		this.prezzo = prezzo;
		this.locandina = locandina;
		this.descrizione = descrizione;
		this.gruppi = gruppi;
		this.tour = tour;
		this.tipologia_Eventi = tipologia_Eventi;
	}

	public Evento(int id, Locale locale, String data, String orarioInizio,
			String orarioFine, String nome, String luogo, float prezzo,
			String locandina, String descrizione) {
		super();
		this.id = id;
		this.locale = locale;
		this.data = data;
		this.orarioInizio = orarioInizio;
		this.orarioFine = orarioFine;
		this.nome = nome;
		this.luogo = luogo;
		this.prezzo = prezzo;
		this.locandina = locandina;
		this.descrizione = descrizione;
	}

	public Evento(Locale locale, String data, String orarioInizio,
			String orarioFine, String nome, String luogo, float prezzo,
			String locandina, String descrizione) {
		super();
		this.locale = locale;
		this.data = data;
		this.orarioInizio = orarioInizio;
		this.orarioFine = orarioFine;
		this.nome = nome;
		this.luogo = luogo;
		this.prezzo = prezzo;
		this.locandina = locandina;
		this.descrizione = descrizione;
	}

	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@GeneratedValue(generator="EveSeq")
    @SequenceGenerator(name="EveSeq",sequenceName="EVENTO_SEQ",allocationSize=1)
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}



	@ManyToOne
	public Locale getLocale() {
		return locale;
	}




	public void setLocale(Locale locale) {
		this.locale = locale;
	}




	public String getData() {
		return data;
	}




	public void setData(String data) {
		this.data = data;
	}




	public String getOrarioInizio() {
		return orarioInizio;
	}




	public void setOrarioInizio(String orarioInizio) {
		this.orarioInizio = orarioInizio;
	}




	public String getOrarioFine() {
		return orarioFine;
	}




	public void setOrarioFine(String orarioFine) {
		this.orarioFine = orarioFine;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getLuogo() {
		return luogo;
	}




	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}




	public float getPrezzo() {
		return prezzo;
	}




	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}




	public String getLocandina() {
		return locandina;
	}




	public void setLocandina(String locandina) {
		this.locandina = locandina;
	}




	public String getDescrizione() {
		return descrizione;
	}




	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}



	
	//@ManyToMany(cascade={PERSIST,REFRESH})
	@ManyToMany(fetch=FetchType.EAGER,mappedBy="eventi")
	public Set<Gruppo> getGruppo() {
		return gruppi;
	}




	public void setGruppo(Set<Gruppo> gruppi) {
		this.gruppi = gruppi;
	}



	@ManyToOne(fetch=FetchType.LAZY)
	public Tour getTour() {
		return tour;
	}




	public void setTour(Tour tour) {
		this.tour = tour;
	}



	@OneToOne(fetch=FetchType.EAGER)
	public TipologiaEvento getTipologia_Eventi() {
		return tipologia_Eventi;
	}




	public void setTipologia_Eventi(TipologiaEvento tipologia_Eventi) {
		this.tipologia_Eventi = tipologia_Eventi;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	
	
	
}
