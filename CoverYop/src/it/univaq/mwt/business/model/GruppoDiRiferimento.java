package it.univaq.mwt.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.ManyToMany;

import java.util.Set;
import java.util.HashSet;
import java.util.Set;


import java.util.Set;

import javax.persistence.Access;

import static javax.persistence.AccessType.PROPERTY;

@Entity
@Access(PROPERTY)
public class GruppoDiRiferimento implements Serializable{
	

	private int id;
	
	private String nome;
	
	
	private Set<Gruppo> gruppo = new HashSet<Gruppo>();
	
	private static final long serialVersionUID = 1L;

	public GruppoDiRiferimento() {
		super();
	}

	public GruppoDiRiferimento(int id, String nome, Set<Gruppo> gruppo) {
		super();
		this.id = id;
		this.nome = nome;
		this.gruppo = gruppo;
	}
	
	public GruppoDiRiferimento(String nome, Set<Gruppo> gruppo) {
		super();
		this.nome = nome;
		this.gruppo = gruppo;
	}

	public GruppoDiRiferimento(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public GruppoDiRiferimento(String nome) {
		super();
		this.nome = nome;
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

	@ManyToMany(mappedBy="gruppi_rif")
	public Set<Gruppo> getGruppo() {
		return gruppo;
	}

	public void setGruppo(Set<Gruppo> gruppo) {
		this.gruppo = gruppo;
	}
	

	
}
