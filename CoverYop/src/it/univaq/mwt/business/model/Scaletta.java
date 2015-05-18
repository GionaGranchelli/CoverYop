package it.univaq.mwt.business.model;

import static javax.persistence.AccessType.PROPERTY;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Access(PROPERTY)
public class Scaletta implements Serializable {

	private int id;

	private float durata;

	private Set<Canzone> canzoni;

	private Gruppo gruppo;

	private static final long serialVersionUID = 1L;

	public Scaletta() {
		super();
	}

	public Scaletta(int id, float durata, Set<Canzone> canzoni) {
		super();
		this.id = id;
		this.durata = durata;
		this.canzoni = canzoni;
	}

	public Scaletta(float durata, Set<Canzone> canzoni) {
		super();
		this.durata = durata;
		this.canzoni = canzoni;
	}

	public Scaletta(int id, float durata) {
		super();
		this.id = id;
		this.durata = durata;
	}

	public Scaletta(float durata) {
		super();
		this.durata = durata;
	}

	@Id
	// @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@GeneratedValue(generator = "ScaSeq")
	@SequenceGenerator(name = "ScaSeq", sequenceName = "SCALETTA_SEQ", allocationSize = 1)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getDurata() {
		return durata;
	}

	public void setDurata(float durata) {
		this.durata = durata;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "scaletta", cascade = { PERSIST,
			REFRESH })
	public Set<Canzone> getCanzoni() {
		return canzoni;
	}

	public void setCanzoni(Set<Canzone> canzoni) {
		this.canzoni = canzoni;
	}

	@OneToOne
	public Gruppo getGruppo() {
		return gruppo;
	}

	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}

}
