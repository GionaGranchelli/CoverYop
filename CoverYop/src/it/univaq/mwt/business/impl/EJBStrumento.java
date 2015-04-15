package it.univaq.mwt.business.impl;

import it.univaq.mwt.business.StrumentoService;




import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

/**
 * Session Bean implementation class EJBStrumento
 */

@Service
public class EJBStrumento implements StrumentoService {

	@PersistenceContext(unitName="Yop-domain")
	private EntityManager em;
	
    public EJBStrumento() {
        // TODO Auto-generated constructor stub
    }

}
