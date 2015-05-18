package it.univaq.mwt.business.impl;

import it.univaq.mwt.business.RuoloService;
import it.univaq.mwt.business.model.Ruolo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

/**
 * Session Bean implementation class EJBRuoli
 */

@Service
public class EJBRuolo implements RuoloService {

	@PersistenceContext(unitName = "Yop-domain")
	private EntityManager em;

	public EJBRuolo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Ruolo getRuoloByName(String nome) {

		Query query = em.createQuery("select r from Ruolo r where r.nome =:nome");
		query.setParameter("nome", nome);

		Ruolo role = (Ruolo) query.getSingleResult();

		return role;
	}

}
