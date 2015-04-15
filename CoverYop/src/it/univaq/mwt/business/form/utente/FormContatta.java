package it.univaq.mwt.business.form.utente;

public class FormContatta {

	
	
	private int id;
		
	private String titolo;
	
	private String corpo;
	
	
	public FormContatta() {
}


	public FormContatta(int id, String titolo, String corpo) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.corpo = corpo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public String getCorpo() {
		return corpo;
	}


	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	
	
}
