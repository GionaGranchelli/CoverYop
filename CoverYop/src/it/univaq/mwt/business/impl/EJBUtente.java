package it.univaq.mwt.business.impl;

import it.univaq.mwt.business.UtenteService;
import it.univaq.mwt.business.model.Utente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
@Service
public class EJBUtente implements UtenteService {
	
	

	@PersistenceContext(unitName="Yop-domain")
	private EntityManager em;

	public EJBUtente() {
		
	}

	@Override
	public Utente findUtenteById(int id) {
		Utente user = em.find(Utente.class, id);
		return user;
	}

}
