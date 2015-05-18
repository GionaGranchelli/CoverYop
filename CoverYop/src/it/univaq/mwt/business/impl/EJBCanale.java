package it.univaq.mwt.business.impl;

import it.univaq.mwt.business.CanaleService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

/**
 * Session Bean implementation class EJBCanale
 */

@Service
public class EJBCanale implements CanaleService {

	@PersistenceContext(unitName = "Yop-domain")
	private EntityManager em;

	public EJBCanale() {
		// TODO Auto-generated constructor stub
	}

}
