package it.univaq.mwt.business.impl;

import it.univaq.mwt.business.AlbumService;
import it.univaq.mwt.business.CanzoneService;
import it.univaq.mwt.business.model.Album;
import it.univaq.mwt.business.model.Canzone;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Session Bean implementation class Manager
 */

@Service
public class EJBCanzoni implements CanzoneService {

	@PersistenceContext(unitName="Yop-domain")
	private EntityManager em;
	
	
	@Autowired
	AlbumService albumService;
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
		Album a = c.getAlbum();
		em.remove(c);
		em.refresh(a);
		em.getEntityManagerFactory().getCache().evictAll();
		
	}

	@Override
	public List<Canzone> findLastSong(int i) {
		
			String queryString="select distinct(cz) from Gruppo grp, Album alb, Canzone cz where cz.album = alb and alb.gruppo = grp  ORDER BY cz.id DESC";
		
		//String queryString = "select c from Canzone c ORDER BY c.id";
		Query query = em.createQuery(queryString);
		query.setMaxResults(i);
		List<Canzone> result = (List<Canzone>)query.getResultList();
		return result;
	
	}


	
}
