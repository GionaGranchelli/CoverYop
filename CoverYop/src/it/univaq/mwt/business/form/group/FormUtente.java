package it.univaq.mwt.business.form.group;

public class FormUtente {

	private String username;
	
	private String password;
	
	private String email;
	
	private String telefono;
	
	private String nome;	
	
	private String cognome;
	
	private String citta;
	
	private String indirizzo;

	
	public FormUtente() {
		super();
	}

	public FormUtente(String username, String password, String email,
			String telefono, String nome, String cognome, String citta,
			String indirizzo) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.telefono = telefono;
		this.nome = nome;
		this.cognome = cognome;
		this.citta = citta;
		this.indirizzo = indirizzo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	
}
