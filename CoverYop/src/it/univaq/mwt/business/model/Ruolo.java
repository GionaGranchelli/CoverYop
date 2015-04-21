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
public class Ruolo implements Serializable{
	
	
	private int id;
	
	private String nome;
	
	private String descrizione;
	
	private Set<Utente> utente = new HashSet<Utente>();
	
	
	private static final long serialVersionUID = 1L;

	public Ruolo() {
		super();
	}


	public Ruolo(String nome, String descrizione) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
	}
	
	


	public Ruolo(int id, String nome, String descrizione) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
	}

	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@GeneratedValue(generator="RuoSeq")
    @SequenceGenerator(name="RuoSeq",sequenceName="RUOLO_SEQ",allocationSize=1)
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


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@OneToMany(fetch=FetchType.LAZY,cascade={PERSIST,REFRESH},mappedBy="ruolo")
	public Set<Utente> getUtente() {
		return utente;
	}


	public void setUtente(Set<Utente> utente) {
		this.utente = utente;
	}

	
}
