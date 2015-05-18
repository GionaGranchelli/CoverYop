package it.univaq.mwt.business.impl;

import it.univaq.mwt.business.UtenteService;
import it.univaq.mwt.business.model.Utente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EJBUtente implements UtenteService {

	@PersistenceContext(unitName = "Yop-domain")
	private EntityManager em;

	public EJBUtente() {

	}

	@Override
	public Utente findUtenteById(int id) {
		Utente user = em.find(Utente.class, id);
		return user;
	}

	@Transactional
	public void update(Utente utente) {
		em.merge(utente);
	}

	@Override
	public Utente findUtenteByUsername(String username) {
		String gruppoToLower = username.toLowerCase();

		Query query = em.createQuery("select lc " + "from Utente lc "
				+ "where lower(lc.username) LIKE :localeLow");
		query.setParameter("localeLow", "%" + gruppoToLower + "%");
		query.setMaxResults(1);
		Utente user;
		try {
			user = (Utente) query.getSingleResult();
		} catch (NullPointerException e) {

			return null;
		}
		return user;
	}

	public Utente findUtente(Utente u) {
		Utente user = em.find(Utente.class, u.getId());
		return user;
	}

}
