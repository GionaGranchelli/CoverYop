package it.univaq.mwt.business.model;

import static javax.persistence.AccessType.PROPERTY;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Access(PROPERTY)
@PrimaryKeyJoinColumn(name = "locale_id", referencedColumnName = "USER_ID")
@DiscriminatorValue("local")
public class Locale extends Utente implements Serializable{
	
	
	
	private String nomeLocale;
	
	private ServiceMusicale service; // cambiato perchè non gli serve avere un SET di service
	
	
	//private Set<Feedback> feedback;   //togliere - unidirezionale
	
	private Set<String> contatti = new HashSet<String>(); //visto che Utente ha già il telefono quest oattributo può essere il secondo num di telefono
	
	
	private Set<Evento> eventi = new HashSet<Evento>();  //togliere - unidirezionale
	
	private Categoria categoria; //è il tipo di locale (es. bar - ristorante) NB. Il locale può avere solo un  tipo di categoria
	
	private String orarioApertura;
	
	private String orarioChiusura;
	
	private String descrizione;

	private static final long serialVersionUID = 1L;
	
	public Locale() {
		super();
	}



	public Locale( String nomeLocale, ServiceMusicale service, Set<String> contatti, Set<Evento> eventi,
			Categoria categoria, String orarioApertura, String orarioChiusura,
			String descrizione) {
		super();
		
		this.nomeLocale = nomeLocale;
		this.service = service;
		//this.feedback = feedback;
		this.contatti = contatti;
		this.eventi = eventi;
		this.categoria = categoria;
		this.orarioApertura = orarioApertura;
		this.orarioChiusura = orarioChiusura;
		this.descrizione = descrizione;
	}
	



	public Locale( String nomeLocale, Set<String> contatti,
			String orarioApertura, String orarioChiusura, String descrizione) {
		super();
		
		this.nomeLocale = nomeLocale;
		this.contatti = contatti;
		this.orarioApertura = orarioApertura;
		this.orarioChiusura = orarioChiusura;
		this.descrizione = descrizione;
	}
	
	public String getNomeLocale() {
		return nomeLocale;
	}



	public void setNomeLocale(String nomeLocale) {
		this.nomeLocale = nomeLocale;
	}

	@JsonIgnore
	@Embedded
	public ServiceMusicale getService() {
		return service;
	}



	public void setService(ServiceMusicale service) {
		this.service = service;
	}


//	@OneToMany(fetch=FetchType.LAZY)
//	public Set<Feedback> getFeedback() {
//		return feedback;
//	}
//
//
//
//	public void setFeedback(Set<Feedback> feedback) {
//		this.feedback = feedback;
//	}



	public Set<String> getContatti() {
		return contatti;
	}



	public void setContatti(Set<String> contatti) {
		this.contatti = contatti;
	}

	@JsonIgnore
	@OneToMany(mappedBy="locale", fetch=FetchType.EAGER, cascade={PERSIST, REFRESH})
	public Set<Evento> getEventi() {
		return eventi;
	}



	public void setEventi(Set<Evento> eventi) {
		this.eventi = eventi;
	}


	@Embedded
	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	public String getOrarioApertura() {
		return orarioApertura;
	}



	public void setOrarioApertura(String orarioApertura) {
		this.orarioApertura = orarioApertura;
	}



	public String getOrarioChiusura() {
		return orarioChiusura;
	}



	public void setOrarioChiusura(String orarioChiusura) {
		this.orarioChiusura = orarioChiusura;
	}



	public String getDescrizione() {
		return descrizione;
	}



	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
	
}
