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
public class ServiceMusicale implements Serializable{
	
	
	private boolean palco;
	
	private float casse; //ci vanno i watt
	
	private int mixer; // ci metto il numero di canali..... 0 se il mixer non è presente
	
	private boolean amplificatore;
	
	private boolean microfono;
	
	private boolean batteria;
	
	private boolean luci;
	
	private static final long serialVersionUID = 1L;
	
	public ServiceMusicale() {
		super();
	}


	
	
	public ServiceMusicale(boolean palco, float casse, int mixer,
			boolean amplificatore, boolean microfono, boolean batteria,
			boolean luci) {
		super();
		this.palco = palco;
		this.casse = casse;
		this.mixer = mixer;
		this.amplificatore = amplificatore;
		this.microfono = microfono;
		this.batteria = batteria;
		this.luci = luci;
	}

	


	public boolean isPalco() {
		return palco;
	}


	public void setPalco(boolean palco) {
		this.palco = palco;
	}


	public float getCasse() {
		return casse;
	}


	public void setCasse(float casse) {
		this.casse = casse;
	}


	public int getMixer() {
		return mixer;
	}


	public void setMixer(int mixer) {
		this.mixer = mixer;
	}


	public boolean isAmplificatore() {
		return amplificatore;
	}


	public void setAmplificatore(boolean amplificatore) {
		this.amplificatore = amplificatore;
	}


	public boolean isMicrofono() {
		return microfono;
	}


	public void setMicrofono(boolean microfono) {
		this.microfono = microfono;
	}


	public boolean isBatteria() {
		return batteria;
	}


	public void setBatteria(boolean batteria) {
		this.batteria = batteria;
	}


	public boolean isLuci() {
		return luci;
	}


	public void setLuci(boolean luci) {
		this.luci = luci;
	}


	

}
