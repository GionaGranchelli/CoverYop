package it.univaq.mwt.business.model;

import static javax.persistence.AccessType.PROPERTY;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Access(PROPERTY)
public class TipologiaEvento implements Serializable {

	private int id;

	private String nome;

	private String descrizione;

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

	@Id
	// @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@GeneratedValue(generator = "TipSeq")
	@SequenceGenerator(name = "TipSeq", sequenceName = "TIPOLOGIAEVENTO_SEQ", allocationSize = 1)
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

}
