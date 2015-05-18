package it.univaq.mwt.business.model;

import static javax.persistence.AccessType.PROPERTY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
@Access(PROPERTY)
public class Genere implements Serializable {

	private int id;

	private String genere;

	private Set<Gruppo> gruppo = new HashSet<Gruppo>();

	private static final long serialVersionUID = 1L;

	public Genere() {
		super();
	}

	public Genere(int id, String genere, Set<Gruppo> gruppo) {
		super();
		this.id = id;
		this.genere = genere;
		this.gruppo = gruppo;
	}

	public Genere(String genere, Set<Gruppo> gruppo) {
		super();
		this.genere = genere;
		this.gruppo = gruppo;
	}

	public Genere(int id, String genere) {
		super();
		this.id = id;
		this.genere = genere;
	}

	public Genere(String genere) {
		super();
		this.genere = genere;
	}

	@Id
	// @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@GeneratedValue(generator = "GenSeq")
	@SequenceGenerator(name = "GenSeq", sequenceName = "GENERE_SEQ", allocationSize = 1)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@ManyToMany(mappedBy = "generi")
	public Set<Gruppo> getGruppo() {
		return gruppo;
	}

	public void setGruppo(Set<Gruppo> gruppo) {
		this.gruppo = gruppo;
	}

}
