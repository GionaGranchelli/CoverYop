package it.univaq.mwt.business.impl;

import java.util.Date;
import java.util.List;

import it.univaq.mwt.business.VideoService;


import it.univaq.mwt.business.model.Album;
import it.univaq.mwt.business.model.Canzone;
import it.univaq.mwt.business.model.Locale;
import it.univaq.mwt.business.model.Video;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Session Bean implementation class EJBVideo
 */

@Service
public class EJBVideo implements VideoService {

	@PersistenceContext(unitName="Yop-domain")
	private EntityManager em;
	
    public EJBVideo() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Video> getAllVideoByGroupId(int groupId) {
		
		Query query = em.createQuery("select ab "
				+ "from Video ab, Gruppo gr "
				+ "where ab.utente.id =:groupId");
		query.setParameter("groupId", groupId);
		List<Video> result = (List<Video>) query.getResultList();
		return result;
	}
	@Transactional
	public int deleteVideo(int videoID){
		
		Query query = em.createQuery("delete from Video f where f.id =:videoID");
		query.setParameter("videoID", videoID);
		int result = query.executeUpdate();
		em.getEntityManagerFactory().getCache().evictAll();
		
		return result;
	}

	@Override
	public Video getVideoById(int videoID) {
		Query query = em.createQuery("select v from Video v where f.id=:videoID");
		query.setParameter("VideoID", videoID);
		Video v = (Video) query.getSingleResult();
		return v;
	}

	@Override
	public Video updateVideo(Video v) {
		Video updatedVideo = em.merge(v);
		return updatedVideo;
		
	}

	@Override
	public void deleteVideo(Video v) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public Video insertVideo(Video v) {
		Video toPersist = v;
		em.persist(toPersist);
		em.getEntityManagerFactory().getCache().evictAll();
		return toPersist;
	}

	@Override
	public Video buildVideoInfo(Locale l, Video v) {
		Video toPersist = v;
		toPersist.setUtente(l);
		toPersist.setData(new Date());
		toPersist.setTag("Video");
		return toPersist;
		
		
	}

}
