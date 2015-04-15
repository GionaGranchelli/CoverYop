package it.univaq.mwt.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import it.univaq.mwt.business.GenereService;
import it.univaq.mwt.business.model.Genere;





import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

/**
 * Session Bean implementation class EJBGenere
 */

@Service
public class EJBGenere implements GenereService {

	@PersistenceContext(unitName="Yop-domain")
	private EntityManager em;

	
    public EJBGenere() {
        // TODO Auto-generated constructor stub
    }

    public List<Genere> findAllGeneri(){
    	Query query = em.createQuery("select gn "
				+ "from Genere gn");
		
		
	List<Genere> result = new ArrayList<Genere>(query.getResultList());
	
		return result;
	
    	
    }
}
