package it.univaq.mwt.business.model;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
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
public class Strumento implements Serializable{
	
	
	private int id;
	
	private String nome;
	
	private String tipologia;
	
	
	private Set<Componente> componente = new HashSet<Componente>();
	
	private static final long serialVersionUID = 1L;
	
	public Strumento() {
		super();
	}

	public Strumento(int id, String nome, String tipologia,
			Set<Componente> componente) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipologia = tipologia;
		this.componente = componente;
	}
	
	public Strumento(String nome, String tipologia,
			Set<Componente> componente) {
		super();
		this.nome = nome;
		this.tipologia = tipologia;
		this.componente = componente;
	}


	public Strumento(int id, String nome, String tipologia) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipologia = tipologia;
	}
	
	public Strumento(String nome, String tipologia) {
		super();
		this.nome = nome;
		this.tipologia = tipologia;
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


	public String getTipologia() {
		return tipologia;
	}


	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	@OneToMany(mappedBy="strumento",fetch = LAZY,cascade={PERSIST, REFRESH})
	public Set<Componente> getComponente() {
		return componente;
	}


	public void setComponente(Set<Componente> componente) {
		this.componente = componente;
	}
	
	


	
}
