package it.univaq.mwt.business.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.univaq.mwt.business.CanzoneService;
import it.univaq.mwt.business.model.Canzone;
import it.univaq.mwt.business.model.Foto;
import it.univaq.mwt.business.model.Gruppo;

import javax.annotation.Resource;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

/**
 * Session Bean implementation class Manager
 */

@Service
public class EJBCanzoni implements CanzoneService {

	@PersistenceContext(unitName="Yop-domain")
	private EntityManager em;
	
//	@Resource
//	private SessionContext etx;
	
	
    /**
     * Default constructor. 
     */
    public EJBCanzoni() {
        // TODO Auto-generated constructor stub
    }

    public Canzone findCanzoneById(int CanzoneID){
		Query query = em.createQuery("select c from Canzone c where c.id =:CanzoneID");
		query.setParameter("CanzoneID", CanzoneID);
		Canzone  c = (Canzone)query.getSingleResult();
		//Canzone c = new Canzone();
    	return c;
    	
    }

	@Override
	public List<Canzone> findAllCanzoni() {
	Query query = em.createQuery("SELECT c FROM Canzone c");
		
	List<Canzone> canzoni = (List<Canzone>)query.getResultList();
		
    	return canzoni;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void deleteCanzone(int canzoneID) {
		Canzone c = findCanzoneById(canzoneID);
		em.remove(c);
		Query query = em.createQuery("delete from Canzone f where f.id =:canzoneID");
		query.setParameter("canzoneID", canzoneID);
		int result = query.executeUpdate();
		em.getEntityManagerFactory().getCache().evict(Canzone.class);
		
	}

	@Override
	public List findLastSong(int i) {
		
			String queryString="select cz from Gruppo grp, Album alb, Canzone cz where cz.album = alb and alb.gruppo = grp  ORDER BY cz.id DESC";
		
		//String queryString = "select c from Canzone c ORDER BY c.id";
		Query query = em.createQuery(queryString);
		query.setMaxResults(i);
		List result = query.getResultList();
		return result;
	
	}


	
}
