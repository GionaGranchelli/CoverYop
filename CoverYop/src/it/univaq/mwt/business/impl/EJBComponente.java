package it.univaq.mwt.business.impl;

import it.univaq.mwt.business.ComponenteService;




import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

/**
 * Session Bean implementation class EJBComponente
 */

@Service
public class EJBComponente implements ComponenteService {

	@PersistenceContext(unitName="Yop-domain")
	private EntityManager em;

	
    public EJBComponente() {
        // TODO Auto-generated constructor stub
    }

}
