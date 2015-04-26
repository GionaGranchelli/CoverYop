package it.univaq.mwt.business.form.utente;

public class FormConversation {

	private String destinatario;
	
	private String titolo;
	
	private String corpo;

	
	
	public FormConversation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FormConversation(String destinatario, String titolo, String corpo) {
		super();
		this.destinatario = destinatario;
		this.titolo = titolo;
		this.corpo = corpo;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
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
