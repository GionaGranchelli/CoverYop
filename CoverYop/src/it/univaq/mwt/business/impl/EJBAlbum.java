package it.univaq.mwt.business.impl;

import it.univaq.mwt.business.AlbumService;
import it.univaq.mwt.business.model.Album;
import it.univaq.mwt.business.model.Canzone;
import it.univaq.mwt.business.model.Video;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;




//import javax.ejb.Remote;



import java.util.Set;

import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EJBAlbum implements AlbumService {

	@PersistenceContext
	private EntityManager em;
	
    public EJBAlbum() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public Album getAllCanzoniByAlbumId(int albumID) {
			
			
			Query query = em.createQuery("select ab "
					+ "from Album ab "
					+ "where ab.id =:albumID");
			query.setParameter("albumID", albumID);
			
		
		Album result = (Album) query.getSingleResult();
    	return result;
	}

	@Override
	public List<Album> getAllAlbumsByGroupId(int groupId) {

		Query query = em.createQuery("select ab "
				+ "from Album ab, Canzone cz, Gruppo gr "
				+ "where gr.id =:groupId");
		query.setParameter("groupId", groupId);
		List<Album> result = (List<Album>) query.getResultList();
		return result;
	}



	@Transactional
	public void deleteAlbum(int albumID) {
		Query query = em.createQuery("delete from Album alb where alb.id =:albumID");
		query.setParameter("albumID", albumID);
		query.executeUpdate();
		em.getEntityManagerFactory().getCache().evict(Album.class);
		
		
	}
	public int emptyAlbum(Album alb){
		Query query = em.createQuery("SELECT COUNT(alb.canzoni) FROM Album alb WHERE alb.id=:albumID");
		query.setParameter("albumID", alb.getId());
		Long i = (Long) query.getSingleResult();
		System.out.println("Quanti ce ne sono? " + i.intValue());
		return i.intValue();
		
	}

}
