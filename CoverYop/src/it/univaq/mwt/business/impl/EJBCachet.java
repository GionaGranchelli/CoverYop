package it.univaq.mwt.business.impl;

import it.univaq.mwt.business.CachetService;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

/**
 * Session Bean implementation class EJBCachet
 */

@Service
public class EJBCachet implements CachetService {

	@PersistenceContext(unitName="Yop-domain")
	private EntityManager em;
	
	
    public EJBCachet() {
        // TODO Auto-generated constructor stub
    }

}
