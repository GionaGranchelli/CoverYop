package it.univaq.mwt.business.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import it.univaq.mwt.business.BusinessException;
import it.univaq.mwt.business.SecurityService;
import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.business.model.Locale;

import it.univaq.mwt.business.model.Utente;


@Service
public class EJBSecurityService implements SecurityService {
	
	@PersistenceContext(unitName="Yop-domain")
	private EntityManager em;

	@Override
	public Utente authenticate(String username) throws BusinessException {
			
//			System.out.println("quà ci sò passato eh");
			Query query = em.createQuery("select u from Utente u JOIN FETCH u.ruolo where u.username =:username");
			query.setParameter("username", username);			
			Utente utente = (Utente) query.getSingleResult();
//			System.out.println("utente:  "+utente.getNome()+"---"
//								+utente.getUsername()+"-------"+utente.getRuolo().getNome());
			return utente;
	}

}
