package it.univaq.mwt.business;

import it.univaq.mwt.business.model.Utente;

public interface UtenteService {

	Utente findUtenteById(int id);
	void update(Utente utente);
	Utente findUtente(Utente u);
}
