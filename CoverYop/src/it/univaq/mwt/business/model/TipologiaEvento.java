package it.univaq.mwt.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Access;

import static javax.persistence.AccessType.PROPERTY;

@Entity
@Access(PROPERTY)
public class TipologiaEvento implements Serializable{
	
	
	private int id;
	
	private String nome;
	
	private String descrizione;
	
	private Evento evento;
	
	private static final long serialVersionUID = 1L;
	
	public TipologiaEvento() {
		super();
	}

	public TipologiaEvento(int id, String nome, String descrizione) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
	}
	
	public TipologiaEvento(String nome, String descrizione) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		
	}


	public TipologiaEvento(String nome, String descrizione, Evento evento) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.evento = evento;
	}

	public TipologiaEvento(int id, String nome, String descrizione,
			Evento evento) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.evento = evento;
	}

	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@GeneratedValue(generator="TipSeq")
    @SequenceGenerator(name="TipSeq",sequenceName="TIPOLOGIAEVENTO_SEQ",allocationSize=1)
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
	@OneToOne//(mappedBy="tipologia_Eventi")//da modificare ci va @OneToMany(mappedBy="tipologia_Eventi")il db sottostante è stata modellata male
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	

	
	
}
