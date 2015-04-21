package it.univaq.mwt.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;



import java.util.Collection;
import java.util.Set;
import javax.persistence.Access;
import static javax.persistence.AccessType.PROPERTY;

@Embeddable
@Access(PROPERTY)
public class Categoria implements Serializable{
	
	private String nomeCat;
	
	private String descrizioneCat;
	
	private static final long serialVersionUID = 1L;
	
	public Categoria() {
		super();
	}
	
	
	
	public Categoria(String nome, String descrizione) {
		super();
		this.nomeCat = nome;
		this.descrizioneCat = descrizione;
	}

	
	public String getNomeCat() {
		return nomeCat;
	}

	public void setNomeCat(String nome) {
		this.nomeCat = nome;
	}

	public String getDescrizioneCat() {
		return descrizioneCat;
	}

	public void setDescrizioneCat(String descrizione) {
		this.descrizioneCat = descrizione;
	}

	
}
