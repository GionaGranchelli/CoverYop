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
	
	private boolean consumazioni;
	
	private boolean rimborsoSpese;
	
	private static final long serialVersionUID = 1L;
	
	
	public Cachet() {
		super();
	}
	
	

	public Cachet(float prezzo, boolean consumazioni, boolean rimborsoSpese) {
		super();
		this.prezzo = prezzo;
		this.setConsumazioni(consumazioni);
		this.setRimborsoSpese(rimborsoSpese);
	}


	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}



	public boolean isConsumazioni() {
		return consumazioni;
	}



	public void setConsumazioni(boolean consumazioni) {
		this.consumazioni = consumazioni;
	}



	public boolean isRimborsoSpese() {
		return rimborsoSpese;
	}



	public void setRimborsoSpese(boolean rimborsoSpese) {
		this.rimborsoSpese = rimborsoSpese;
	}

	
	
	

	
}
