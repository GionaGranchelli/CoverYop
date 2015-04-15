package it.univaq.mwt.business.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.univaq.mwt.business.TipologiaEventoService;


import it.univaq.mwt.business.model.Evento;
import it.univaq.mwt.business.model.TipologiaEvento;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

/**
 * Session Bean implementation class EJBTipologiaEvento
 */

@Service
public class EJBTipologiaEvento implements TipologiaEventoService {

	@PersistenceContext(unitName="Yop-domain")
	private EntityManager em;
	
    public EJBTipologiaEvento() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<TipologiaEvento> getAllTipologiaEvento() {
		em.clear();
		Query query =em.createQuery("Select te from TipologiaEvento te");
		List<TipologiaEvento> result = (List<TipologiaEvento>) query.getResultList();
		em.getEntityManagerFactory().getCache().evictAll();
		return result;
	}

	
	@Override
	public TipologiaEvento getTipologiaEventoById(int tipoloEventoID) {
		// TODO Auto-generated method stub
		return null;
	}

}
