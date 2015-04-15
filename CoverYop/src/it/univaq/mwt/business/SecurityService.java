package it.univaq.mwt.business;

import it.univaq.mwt.business.model.Utente;

public interface SecurityService {

	Utente authenticate(String username) throws BusinessException;
}
