package it.univaq.mwt.business.impl;

import it.univaq.mwt.business.TipologiaEventoService;
import it.univaq.mwt.business.model.TipologiaEvento;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

/**
 * Session Bean implementation class EJBTipologiaEvento
 */

@Service
public class EJBTipologiaEvento implements TipologiaEventoService {

	@PersistenceContext(unitName = "Yop-domain")
	private EntityManager em;

	public EJBTipologiaEvento() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<TipologiaEvento> getAllTipologiaEvento() {
		em.clear();
		Query query = em.createQuery("Select te from TipologiaEvento te");
		List<TipologiaEvento> result = (List<TipologiaEvento>) query.getResultList();
		em.getEntityManagerFactory().getCache().evictAll();
		return result;
	}

	@Override
	public TipologiaEvento getTipologiaEventoById(int tipoloEventoID) {
		TipologiaEvento tE = em.find(TipologiaEvento.class, tipoloEventoID);
		return tE;
	}

}
