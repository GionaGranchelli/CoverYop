package it.univaq.mwt.business.model;

import static javax.persistence.AccessType.PROPERTY;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.Embeddable;

@Embeddable
@Access(PROPERTY)
public class Categoria implements Serializable {

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
