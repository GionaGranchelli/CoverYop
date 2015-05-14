package it.univaq.mwt.business;

import it.univaq.mwt.business.model.Utente;

public interface UtenteService {



	
	public Utente findUtenteByUsername(String username);

	Utente findUtenteById(int id);
	void update(Utente utente);
	Utente findUtente(Utente u);

}
