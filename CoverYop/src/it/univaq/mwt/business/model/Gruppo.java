package it.univaq.mwt.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;


import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import static javax.persistence.TemporalType.DATE;

import java.util.Set;
import java.util.Set;

import javax.persistence.Access;

import static javax.persistence.AccessType.PROPERTY;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.CascadeType.REMOVE;

@Entity
@Access(PROPERTY)
@PrimaryKeyJoinColumn(name = "gruppo_id", referencedColumnName = "USER_ID")
@DiscriminatorValue("group")
public class Gruppo extends Utente implements Serializable{
	
	private String biografia;
	
	private Date data;
	
	private int cover_Band;
	
	private String nomeGruppo;
	
	private ServiceMusicale service;
		
	private Cachet cachet;
	
	private Set<Album> albums = new HashSet<Album>();  // togliere - unidirezionale
		
	private Set<Componente> componente = new HashSet<Componente>(); //  bidirezionale join column 
	
	private Set<Evento> eventi = new HashSet<Evento>(); 
		
	private Set<Genere> generi = new HashSet<Genere>();  
		
//	private Set<Feedback> feedback;
		
	private Set<Tour> tour = new HashSet<Tour>();
		
	private Set<GruppoDiRiferimento> gruppi_rif = new HashSet<GruppoDiRiferimento>() ; 
		
//	private Set<TipologiaEvento> tipologia_eventi = new HashSet<TipologiaEvento>();
	
	private Scaletta scaletta;
	
	private static final long serialVersionUID = 1L;
	
	public Gruppo() {
		super();
	}

	public Gruppo(String biografia, Date data, int cover_Band,
			String nomeGruppo, ServiceMusicale service, Cachet cachet,
			Set<Album> albums, Set<Componente> componente, Set<Evento> eventi,
			Set<Genere> generi, Set<Tour> tour,
			Set<GruppoDiRiferimento> gruppi_rif) {
		super();
		this.biografia = biografia;
		this.data = data;
		this.cover_Band = cover_Band;
		this.nomeGruppo = nomeGruppo;
		this.service = service;
		this.cachet = cachet;
		this.albums = albums;
		this.componente = componente;
		this.eventi = eventi;
		this.generi = generi;
		this.tour = tour;
		this.setGruppi_rif(gruppi_rif);
//		this.tipologia_eventi = tipologia_eventi;
	}

	public Gruppo(String biografia, Date data, int cover_Band,
			String nomeGruppo) {
		super();
		this.biografia = biografia;
		this.data = data;
		this.cover_Band = cover_Band;
		this.nomeGruppo = nomeGruppo;
	}
	
	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	@Temporal(DATE)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getCover_Band() {
		return cover_Band;
	}

	public void setCover_Band(int cover_Band) {
		this.cover_Band = cover_Band;
	}

	public String getNomeGruppo() {
		return nomeGruppo;
	}

	public void setNomeGruppo(String nomeGruppo) {
		this.nomeGruppo = nomeGruppo;
	}
	
	@Embedded
	public ServiceMusicale getService() {
		return service;
	}

	public void setService(ServiceMusicale service) {
		this.service = service;
	}
	@Embedded
	public Cachet getCachet() {
		return cachet;
	}

	public void setCachet(Cachet cachet) {
		this.cachet = cachet;
	}

	@OneToMany(fetch=FetchType.EAGER, mappedBy="gruppo",cascade={PERSIST, REFRESH, REMOVE, CascadeType.MERGE})
	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> album) {
		this.albums = album;
	}
	
	public void addAlbum(Album album){
		this.albums.add(album);
	}

	@OneToMany(fetch=FetchType.EAGER, mappedBy="gruppo",cascade={PERSIST, REFRESH, REMOVE})
	public Set<Componente> getComponente() {
		return componente;
	}

	public void setComponente(Set<Componente> componente) {
		this.componente = componente;
	}
	public void addComponente(Componente componente){
		this.componente.add(componente);
	}

	
	//@ManyToMany(mappedBy="gruppi")
	@ManyToMany(cascade={PERSIST,REFRESH})
	@OrderBy("data DESC")
	public Set<Evento> getEventi() {
		return eventi;
	}

	public void setEventi(Set<Evento> eventi) {
		this.eventi = eventi;
	}
	public void addEvento(Evento evento){
		this.eventi.add(evento);
	}
	@ManyToMany(fetch=FetchType.EAGER, cascade={PERSIST,REFRESH})
	public Set<Genere> getGeneri() {
		return generi;
	}

	public void setGeneri(Set<Genere> genere) {
		this.generi = genere;
	}
	public void addGenere(Genere genere){
		this.generi.add(genere);
	}

	public void addGenereList(Set<Genere> genere){
		
		this.generi.addAll(genere);
	}
	public void printGeneri(){
		Iterator<Genere> i = this.generi.iterator();
		while(i.hasNext()){
			Genere temp = i.next();
			System.out.println("Genere -> " +temp.getGenere() );
		}
	}
//	@OneToMany(fetch=FetchType.EAGER)
//	public Set<Feedback> getFeedback() {
//		return feedback;
//	}
//
//	public void setFeedback(Set<Feedback> feedback) {
//		this.feedback = feedback;
//	}

	@OneToMany(fetch=FetchType.LAZY,cascade={PERSIST,REFRESH},mappedBy="gruppo")
	public Set<Tour> getTour() {
		return tour;
	}

	public void setTour(Set<Tour> tour) {
		this.tour = tour;
	}
	
	public void addTour(Tour t) {
		t.setGruppo(this);
		tour.add(t);
	}

	
	


	@OneToOne(cascade={PERSIST,REFRESH, REMOVE})
	public Scaletta getScaletta() {
		return scaletta;
	}



	public void setScaletta(Scaletta scaletta) {
		this.scaletta = scaletta;
	}


	@ManyToMany(cascade={PERSIST,REFRESH})
	public Set<GruppoDiRiferimento> getGruppi_rif() {
		return gruppi_rif;
	}



	public void setGruppi_rif(Set<GruppoDiRiferimento> gruppi_rif) {
		this.gruppi_rif = gruppi_rif;
	}
	public void addGruppi_rif(GruppoDiRiferimento gruppi_rif){
		this.gruppi_rif.add(gruppi_rif);
	}
	
	public void updateEvento(Evento v){
		
		Set<Evento> nuoviEventi = new HashSet<Evento>();
		Iterator<Evento> i = this.eventi.iterator();
		while(i.hasNext()){
			Evento temp = i.next();
			if(temp.getId() == v.getId()){
				nuoviEventi.add(v);
			}else{
				nuoviEventi.add(temp);
			}
		}
		setEventi(nuoviEventi);
	}
	public void printEvents(){
		Iterator<Evento> i = this.eventi.iterator();
		while(i.hasNext()){
			Evento temp = i.next();
			System.out.println("Evento Id" + temp.getId());
			System.out.println("Evento Nome"+ temp.getNome());
			System.out.println("Evento Locale"+ temp.getLocale().getNomeLocale());
		}
	}
	
	

//	@ManyToMany
//	public Set<TipologiaEvento> getTipologia_eventi() {
//		return tipologia_eventi;
//	}
//
//	public void setTipologia_eventi(Set<TipologiaEvento> tipologia_eventi) {
//		this.tipologia_eventi = tipologia_eventi;
//	}

	
	
}
