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

import java.util.Collection;
import java.util.Set;

import javax.persistence.Access;

import static javax.persistence.AccessType.PROPERTY;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

@Entity
@Access(PROPERTY)
public class Tour implements Serializable{
	
	
	private int id;
	
	private String nome;
	
	private int durata;
	
	
	private Set<Evento> eventi = new HashSet<Evento>();
	
	
	private Gruppo gruppo;
	
	private static final long serialVersionUID = 1L;
	
	public Tour() {
		super();
	}


	public Tour(int id, String nome, int durata, Set<Evento> eventi,
			Gruppo gruppo) {
		super();
		this.id = id;
		this.nome = nome;
		this.durata = durata;
		this.eventi = eventi;
		this.gruppo = gruppo;
	}
	
	public Tour(String nome, int durata, Set<Evento> eventi,
			Gruppo gruppo) {
		super();
		this.nome = nome;
		this.durata = durata;
		this.eventi = eventi;
		this.gruppo = gruppo;
	}


	public Tour(int id, String nome, int durata) {
		super();
		this.id = id;
		this.nome = nome;
		this.durata = durata;
	}
	
	public Tour(String nome, int durata) {
		super();
		this.nome = nome;
		this.durata = durata;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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


	public int getDurata() {
		return durata;
	}


	public void setDurata(int durata) {
		this.durata = durata;
	}


	@OneToMany(fetch=FetchType.LAZY,cascade={PERSIST,REFRESH},mappedBy="tour")
	public Set<Evento> getEventi() {
		return eventi;
	}


	public void setEventi(Set<Evento> eventi) {
		this.eventi = eventi;
	}

	@ManyToOne
	public Gruppo getGruppo() {
		return gruppo;
	}


	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}

	
	
	
	
	
}
