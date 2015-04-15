package it.univaq.mwt.business.impl;

import it.univaq.mwt.business.ScalettaService;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

/**
 * Session Bean implementation class EJBScaletta
 */

@Service
public class EJBScaletta implements ScalettaService {

	@PersistenceContext(unitName="Yop-domain")
	private EntityManager em;
	
    public EJBScaletta() {
        // TODO Auto-generated constructor stub
    }

}
