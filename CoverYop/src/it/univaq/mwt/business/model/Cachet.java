package it.univaq.mwt.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;



import java.util.Collection;
import java.util.Set;

@Embeddable
public class Cachet implements Serializable{
	
	
	private float prezzo;
	
	private int consumazioni;
	
	private int rimborsoSpese;
	
	private static final long serialVersionUID = 1L;
	
	
	public Cachet() {
		super();
	}
	
	

	public Cachet(float prezzo, int consumazioni, int rimborsoSpese) {
		super();
		this.prezzo = prezzo;
		this.consumazioni = consumazioni;
		this.rimborsoSpese = rimborsoSpese;
	}


	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public int getConsumazioni() {
		return consumazioni;
	}

	public void setConsumazioni(int consumazioni) {
		this.consumazioni = consumazioni;
	}

	public int getRimborsoSpese() {
		return rimborsoSpese;
	}

	public void setRimborsoSpese(int rimborsoSpese) {
		this.rimborsoSpese = rimborsoSpese;
	}
	
	

	
}
