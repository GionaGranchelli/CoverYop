package it.univaq.mwt.business.form.group;

import it.univaq.mwt.business.model.Cachet;
import it.univaq.mwt.business.model.Canale;
import it.univaq.mwt.business.model.ServiceMusicale;

import java.util.Date;

public class FormGruppo {

	private String biografia;
	
	private String citta;
	
	private Date data;
	
	private int cover_Band;
	
	private String nomeGruppo;
	
	private ServiceMusicale service;
	
	private Canale canale;
		
	private Cachet cachet;

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getCover_Band() {
		return cover_Band;
	}

	public void setCover_Band(int cover_Band) {
		this.cover_Band = cover_Band;
	}

	public String getNomeGruppo() {
		return nomeGruppo;
	}

	public void setNomeGruppo(String nomeGruppo) {
		this.nomeGruppo = nomeGruppo;
	}

	public ServiceMusicale getService() {
		return service;
	}

	public void setService(ServiceMusicale service) {
		this.service = service;
	}

	public Cachet getCachet() {
		return cachet;
	}

	public void setCachet(Cachet cachet) {
		this.cachet = cachet;
	}

	public Canale getCanale() {
		return canale;
	}

	public void setCanale(Canale canale) {
		this.canale = canale;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	
}
