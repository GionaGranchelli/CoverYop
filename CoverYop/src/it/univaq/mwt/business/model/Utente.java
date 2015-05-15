package it.univaq.mwt.business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Access;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import static javax.persistence.AccessType.PROPERTY;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.CascadeType.REMOVE;
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Access(PROPERTY)
@DiscriminatorColumn(name="tipo")
public abstract class Utente implements Serializable{
	
	
	private int id;
	
	private String username;
	
	private String password;
	
	  
    private String retypePassword;
	
	private String email;
	
	private String telefono;
	
	private String nome;	
	
	private String cognome;
	
	private String citta;
	
	private String indirizzo;
	
	private float lat;
	
	private float lng;
	
	@JsonManagedReference
	private Set<Video> video = new HashSet<Video>();  //togliere - unidirezionale
	@JsonManagedReference
	private Set<AlbumFotografico> albumFotografico = new HashSet<AlbumFotografico>(); //togliere - unidirezionale
	
	private Canale canale; 
	
	private Ruolo ruolo; //riguardare: Se la relazione � N:N mettere collection al posto di set
	
	@JsonManagedReference
	private Set<Conversation> conversationMitt;
	@JsonManagedReference
	private Set<Conversation> conversationDest;
	@JsonManagedReference
	private Set<Message> messaggi;
	
	private static final long serialVersionUID = 1L;
	
	public Utente() {
		super();
	}

	public Utente(int id, String username, String password, String email,
			String telefono, String nome, String cognome, String citta,
			String indirizzo, float lat, float lng,
			Set<Video> video,Set<AlbumFotografico> albumFotografico ,Canale canale) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.telefono = telefono;
		this.nome = nome;
		this.cognome = cognome;
		this.citta = citta;
		this.indirizzo = indirizzo;
		this.lat = lat;
		this.lng = lng;
		this.video= video;
		this.albumFotografico = albumFotografico;
		this.canale = canale;
		
	}
	
	public Utente(String username, String password, String email,
			String telefono, String nome, String cognome, String citta,
			String indirizzo, float lat, float lng,
			Set<Video> video, Set<AlbumFotografico>albumFotografico, Canale canale) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.telefono = telefono;
		this.nome = nome;
		this.cognome = cognome;
		this.citta = citta;
		this.indirizzo = indirizzo;
		this.lat = lat;
		this.lng = lng;
		this.video= video;
		this.albumFotografico = albumFotografico;
		this.canale = canale;
		
	}
	
	public Utente(int id, String username, String password, String email,
			String telefono, String nome, String cognome, String citta,
			String indirizzo) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.telefono = telefono;
		this.nome = nome;
		this.cognome = cognome;
		this.citta = citta;
		this.indirizzo = indirizzo;
	}
	
	public Utente(String username, String password, String email,
			String telefono, String nome, String cognome, String citta,
			String indirizzo) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.telefono = telefono;
		this.nome = nome;
		this.cognome = cognome;
		this.citta = citta;
		this.indirizzo = indirizzo;
	}

	@Id
	@Column(name = "USER_ID")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@GeneratedValue(generator="UteSeq")
    @SequenceGenerator(name="UteSeq",sequenceName="UTENTE_SEQ", allocationSize=1)
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}


	@JsonIgnore
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	@JsonIgnore
	@Transient
	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getCitta() {
		return citta;
	}



	public void setCitta(String citta) {
		this.citta = citta;
	}



	public String getIndirizzo() {
		return indirizzo;
	}



	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}



	public float getLat() {
		return lat;
	}



	public void setLat(float lat) {
		this.lat = lat;
	}



	public float getLng() {
		return lng;
	}



	public void setLng(float lng) {
		this.lng = lng;
	}

	@JsonIgnore
	@OneToMany(mappedBy="utente",fetch=FetchType.EAGER,cascade={PERSIST, REFRESH, REMOVE })
	public Set<AlbumFotografico> getAlbumFotografico() {
		return albumFotografico;
	}
	@JsonIgnore
	public void setAlbumFotografico(Set<AlbumFotografico> albumFotografico) {
		this.albumFotografico = albumFotografico;
	}

	@JsonIgnore
	@Embedded
	public Canale getCanale() {
		return canale;
	}



	public void setCanale(Canale canale) {
		this.canale = canale;
	}

	@JsonIgnore
	@ManyToOne
	public Ruolo getRuolo() {
		return ruolo;
	}



	public void setRuolo(Ruolo ruoli) {
		this.ruolo = ruoli;
	}
	@JsonIgnore
	@OneToMany(mappedBy="utente", fetch=FetchType.LAZY,cascade={PERSIST, REFRESH, REMOVE, }) 
	public Set<Video> getVideo() {
		return video;
	}

	public void setVideo(Set<Video> video) {
		this.video = video;
	}
	public void addVideo(Video v){
		this.video.add(v);
	}

	public void addAlbumFoto(AlbumFotografico albf){
		albumFotografico.add(albf);
	}
	@JsonIgnore
	@OneToMany(mappedBy="mittente", fetch=FetchType.EAGER, cascade={PERSIST, REFRESH})
	public Set<Conversation> getConversationMitt() {
		return conversationMitt;
	}

	public void setConversationMitt(Set<Conversation> conversationMitt) {
		this.conversationMitt = conversationMitt;
	}
	@JsonIgnore
	@OneToMany(mappedBy="destinatario", fetch=FetchType.EAGER, cascade={PERSIST, REFRESH})
	public Set<Conversation> getConversationDest() {
		return conversationDest;
	}

	public void setConversationDest(Set<Conversation> conversationDest) {
		this.conversationDest = conversationDest;
	}
	@JsonIgnore
	@OneToMany(mappedBy="autore", fetch=FetchType.LAZY, cascade={PERSIST, REFRESH})
	public Set<Message> getMessaggi() {
		return messaggi;
	}

	public void setMessaggi(Set<Message> messaggi) {
		this.messaggi = messaggi;
	}

	public Foto getFotoProfilo(){
		Iterator<AlbumFotografico> iA = this.albumFotografico.iterator();
		while(iA.hasNext()){
			AlbumFotografico albumFotograficoTemp = iA.next();
			Iterator<Foto> iF = albumFotograficoTemp.getFoto().iterator();
				if(albumFotograficoTemp.getTag().contains("profile")){
					while(iF.hasNext()){
						Foto fotoTemp = iF.next();
						System.out.println("FOTOID= " + fotoTemp.getId());
						System.out.println("ALBUM= " + fotoTemp.getAlbumFotografico().getId());
						if(fotoTemp != null){
							return fotoTemp;
						}
						
						
					}
				}
		}
		return null;
	}
	
	public void setFotoProfilo(AlbumFotografico al){
		//AlbumFotografico albumFotograficoProfilo = this.getAlbumProfilo();
		Iterator<AlbumFotografico> iA = this.albumFotografico.iterator();
		while(iA.hasNext()){
			AlbumFotografico albumFotograficoTemp = iA.next();
				if(albumFotograficoTemp.getTag().contains("profile")){
					this.albumFotografico.remove(albumFotograficoTemp);
					this.albumFotografico.add(al);
				}
		}
	}
	

	public AlbumFotografico getAlbumProfilo(){
		Iterator<AlbumFotografico> iA = this.albumFotografico.iterator();
		while(iA.hasNext()){
			AlbumFotografico albumFotograficoTemp = iA.next();
				if(albumFotograficoTemp.getTag().contains("profile")){
					return albumFotograficoTemp;
				}
		}
		return null;
	}
	
	public Conversation sendMessage(Utente l, String Titolo, String Testo) {
		int id = this.getId();
		//System.out.println(conversation.getCorpo()+conversation.getTitolo());
		Conversation conv = new Conversation();		
		conv.setTitolo(Titolo);
		conv.setStatus(10);
		Utente destinatario = l;
		conv.setDestinatario(destinatario);
		Utente mittente = this;
		conv.setMittente(mittente);
		conv.setData(Calendar.getInstance());
		Message msg = new Message();
		msg.settext(Testo);
		msg.setAutore(mittente);
		msg.setConversation(conv);
		msg.setDataInvio(Calendar.getInstance());
		msg.setStatus(1);
		conv.addMessage(msg);
		Random rand = new Random();
		int randomNum = rand.nextInt((1000 - 10) + 1) + 10;
		conv.setId(randomNum);
		return conv;
	}
	
	public void setIdForAlbumFotografico(){
		
		Iterator<AlbumFotografico> i = albumFotografico.iterator();
		while(i.hasNext()){
			i.next().setUtente(this);
		}
		
	}

	public void printFoto(){
		Iterator<AlbumFotografico> i = this.albumFotografico.iterator();
			while(i.hasNext()){
				AlbumFotografico temp = i.next();
					Iterator<Foto> f = temp.getFoto().iterator();
						while (f.hasNext()) {
							System.out.println("Foto Id " + f.next().getId());
							System.out.println("Foto Url "+ f.next().getUrl());
							
						}
			}
	}
	
	public AlbumFotografico getAlbumSlider(){
		Iterator<AlbumFotografico> iA = this.albumFotografico.iterator();
		while(iA.hasNext()){
			AlbumFotografico albumFotograficoTemp = iA.next();
				if(albumFotograficoTemp.getTag().contains("slideshow")){
					return albumFotograficoTemp;
				}
		}
		return null; //Gestire con un eccezzione
	}
	public void addSenderConversation(Conversation c){
		this.conversationMitt.add(c);
	}
	public void addRiceverConversation(Conversation c){
		this.conversationDest.add(c);
	}
	}
