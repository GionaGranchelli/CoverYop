package it.univaq.mwt.business.form.local;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import it.univaq.mwt.business.model.TipologiaEvento;

public class FormEvento {

	private int idEvento;
	
	private String nome;
	
	private String gruppo;
	
	private String descrizione;
	
	private String dataEvento;
	
	private String orarioInizio;
	
	private String orarioFine;
	
	private CommonsMultipartFile locandina;
	
	private float prezzo;
	
	private int tipologia_Eventi;
	

	public FormEvento(String gruppo, String data, String orarioInizio,
			String orarioFine, String nome, float prezzo,
			CommonsMultipartFile locandina, String descrizione,
			int tipologia_Eventi) {
		super();
		this.gruppo = gruppo;
		this.dataEvento = data;
		this.orarioInizio = orarioInizio;
		this.orarioFine = orarioFine;
		this.nome = nome;
		this.prezzo = prezzo;
		this.locandina = locandina;
		this.descrizione = descrizione;
		this.tipologia_Eventi = tipologia_Eventi;
	}

	public FormEvento() {
		super();
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getGruppo() {
		return gruppo;
	}

	public void setGruppo(String gruppo) {
		this.gruppo = gruppo;
	}

	public String getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getOrarioInizio() {
		return orarioInizio;
	}

	public void setOrarioInizio(String orarioInizio) {
		this.orarioInizio = orarioInizio;
	}

	public String getOrarioFine() {
		return orarioFine;
	}

	public void setOrarioFine(String orarioFine) {
		this.orarioFine = orarioFine;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public CommonsMultipartFile getLocandina() {
		return locandina;
	}

	public void setLocandina(CommonsMultipartFile locandina) {
		this.locandina = locandina;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getTipologia_Eventi() {
		return tipologia_Eventi;
	}

	public void setTipologia_Eventi(int tipologia_Eventi) {
		this.tipologia_Eventi = tipologia_Eventi;
	}
	
	
}
