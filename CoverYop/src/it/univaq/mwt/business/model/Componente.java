package it.univaq.mwt.business.model;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Access;

import static javax.persistence.AccessType.PROPERTY;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.TemporalType.DATE;

@Entity
@Access(PROPERTY)
public class Componente implements Serializable{
	
	
	private int id;
	
	
	private Strumento strumento;
	
	private String nome;
	
	private String cognome;
	
	private String nickName;
	
	
	private Date nascita;
	
	private String bio;
	
	
	private Gruppo gruppo;
	
	private static final long serialVersionUID = 1L;

	public Componente() {
		super();
	}

	public Componente(int id, Strumento strumento, String nome, String cognome,
			String nickName, Date nascita, String bio, Gruppo gruppo) {
		super();
		this.id = id;
		this.strumento = strumento;
		this.nome = nome;
		this.cognome = cognome;
		this.nickName = nickName;
		this.nascita = nascita;
		this.bio = bio;
		this.gruppo = gruppo;
	}

	public Componente(Strumento strumento, String nome, String cognome,
			String nickName, Date nascita, String bio, Gruppo gruppo) {
		super();
		this.strumento = strumento;
		this.nome = nome;
		this.cognome = cognome;
		this.nickName = nickName;
		this.nascita = nascita;
		this.bio = bio;
		this.gruppo = gruppo;
	}
	
	public Componente(int id, Strumento strumento, String nome, String cognome,
			String nickName, Date nascita, String bio) {
		super();
		this.id = id;
		this.strumento = strumento;
		this.nome = nome;
		this.cognome = cognome;
		this.nickName = nickName;
		this.nascita = nascita;
		this.bio = bio;
	}
	
	public Componente(Strumento strumento, String nome, String cognome,
			String nickName, Date nascita, String bio) {
		super();
		this.strumento = strumento;
		this.nome = nome;
		this.cognome = cognome;
		this.nickName = nickName;
		this.nascita = nascita;
		this.bio = bio;
	}
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@GeneratedValue(generator="CompSeq")
    @SequenceGenerator(name="CompSeq",sequenceName="COMPONENTE_SEQ",allocationSize=1)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne    //un componente può suonare più strumenti
	public Strumento getStrumento() {
		return strumento;
	}

	public void setStrumento(Strumento strumento) {
		this.strumento = strumento;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Temporal(DATE)
	public Date getNascita() {
		return nascita;
	}

	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="gruppoId")
	public Gruppo getGruppo() {
		return gruppo;
	}

	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}

	
	
}
