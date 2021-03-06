package it.univaq.mwt.business.impl;

import it.univaq.mwt.business.AlbumService;
import it.univaq.mwt.business.GruppoService;
import it.univaq.mwt.business.model.Album;
import it.univaq.mwt.business.model.Canzone;
import it.univaq.mwt.business.model.Utente;
import it.univaq.mwt.common.utility.SaveFile;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
//import javax.ejb.Remote;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Service
public class EJBAlbum implements AlbumService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	GruppoService gruppoService;

	public EJBAlbum() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Album getAllCanzoniByAlbumId(int albumID) {

		Query query = em.createQuery("select ab " + "from Album ab "
				+ "where ab.id =:albumID");
		query.setParameter("albumID", albumID);

		Album result = (Album) query.getSingleResult();
		return result;
	}

	@Override
	public List<Album> getAllAlbumsByGroupId(int groupId) {

		Query query = em.createQuery("select ab "
				+ "from Album ab, Canzone cz, Gruppo gr " + "where gr.id =:groupId");
		query.setParameter("groupId", groupId);
		List<Album> result = (List<Album>) query.getResultList();
		return result;
	}

	@Transactional
	public void deleteAlbum(int albumID) {
		Album alb = em.find(Album.class, albumID);
		em.remove(alb);
		em.getEntityManagerFactory().getCache().evictAll();

	}

	public int emptyAlbum(Album alb) {
		Query query = em
				.createQuery("SELECT COUNT(alb.canzoni) FROM Album alb WHERE alb.id=:albumID");
		query.setParameter("albumID", alb.getId());
		Long i = (Long) query.getSingleResult();
		System.out.println("Quanti ce ne sono? " + i.intValue());
		return i.intValue();

	}

	@Transactional
	public void saveAlbumWithSong(Utente utente, Album album,
			CommonsMultipartFile[] tracce) {

		SaveFile sf = new SaveFile();
		Set<Canzone> canzoni = new HashSet<Canzone>(sf.saveMusic(tracce, utente.getId()));
		Iterator<Canzone> iterator = canzoni.iterator();
		while (iterator.hasNext()) {
			Canzone temp = iterator.next();
			temp.setAlbum(album);
		}
		album.setCanzoni(canzoni);
		album.setGruppo(gruppoService.findGruppoByUtente(utente));
		em.persist(album);
		em.getEntityManagerFactory().getCache().evictAll();

	}

	@Transactional
	public void updateAlbum(Album a) {
		em.merge(a);

	}

}
