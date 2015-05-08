package it.univaq.mwt.business.impl;

import it.univaq.mwt.business.AlbumFotograficoService;
import it.univaq.mwt.business.model.AlbumFotografico;
import it.univaq.mwt.business.model.Foto;
import it.univaq.mwt.business.model.Utente;

import java.util.Iterator;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EJBAlbumFotografico implements AlbumFotograficoService {

	@PersistenceContext
	private EntityManager em;

	// @Autowired
	// private SessionFactory sessionfactory;
	public EJBAlbumFotografico() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public List<AlbumFotografico> getAllPhotoAlbumsByGroupId(int groupID) {

		Query query = em
				.createQuery("SELECT alb FROM AlbumFotografico alb, Gruppo g WHERE g.id=:groupID AND  alb.utente.id = g.id");
		query.setParameter("groupID", groupID);

		List<AlbumFotografico> albums = (List<AlbumFotografico>) query
				.getResultList();
		Iterator<AlbumFotografico> i = albums.iterator();
		em.flush();

		return albums;

	}

	@Override
	public Foto getFotoProfiloByGroupId(int groupID) {
		Query query = em
				.createQuery("SELECT f FROM  Foto f, AlbumFotografico alb, Gruppo g WHERE g.id=:groupID AND alb.utente.id = g.id AND alb.tag=:profile");
		query.setParameter("groupID", groupID);
		String profile = "profile";
		query.setParameter("profile", profile);
		Foto result = (Foto) query.getSingleResult();
		return result;
	}

	public void addPhotoAlbum(AlbumFotografico album) {
		AlbumFotografico albumToAdd = new AlbumFotografico();
		albumToAdd = album;
		em.persist(albumToAdd);

	}

	public AlbumFotografico updatePhotoAlbum(AlbumFotografico album) {
		AlbumFotografico a = em.merge(album);
		em.getEntityManagerFactory().getCache().evictAll();
		return a;
	}

	@Transactional
	public AlbumFotografico insertAlbumFotografico(AlbumFotografico album) {
		AlbumFotografico a = album;
		em.persist(a);
		em.getEntityManagerFactory().getCache().evictAll();
		return a;
	}

	@Override
	public int emptyAlbumFotografico(AlbumFotografico album) {
		Query query = em
				.createQuery("SELECT COUNT(alb) FROM AlbumFotografico alb WHERE alb.utente.id=:albumID");
		query.setParameter("albumID", album.getUtente().getId());
		Long i = (Long) query.getSingleResult();
		return i.intValue();
	}

	// @Transactional
	// public void removeAlbumFotografico(AlbumFotografico album) {
	// Query query =
	// em.createQuery("delete from AlbumFotografico f where f.id =:albumID");
	// query.setParameter("albumID", album.getId());
	// query.executeUpdate();
	// em.getEntityManagerFactory().getCache().evict(AlbumFotografico.class);
	//
	// }

	@Override
	public AlbumFotografico getAlbumFotograficoById(int albumID) {
		Query query = em
				.createQuery("select a from AlbumFotografico a where a.id =:albumID");
		query.setParameter("albumID", albumID);
		AlbumFotografico a = (AlbumFotografico) query.getSingleResult();
		// Canzone c = new Canzone();
		return a;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void removeAlbumFotografico(int albumID) {
		AlbumFotografico al = getAlbumFotograficoById(albumID);
		em.remove(al);

		Query query = em
				.createQuery("delete from AlbumFotografico al where al.id =:albumID");
		query.setParameter("albumID", albumID);
		int result = query.executeUpdate();
		em.getEntityManagerFactory().getCache().evict(AlbumFotografico.class);
	}

	@Override
	public List<AlbumFotografico> getLastSubscribed(int i) {
		String queryString = "select af from AlbumFotografico af ORDER BY af.id";
		Query query = em.createQuery(queryString);
		query.setMaxResults(i);
		List<AlbumFotografico> result = (List<AlbumFotografico>) query
				.getResultList();
		return result;

	}

	@Transactional
	public void removeEmptyAlbums(Utente utente) {
		List<AlbumFotografico> albums = getAllPhotoAlbumsByGroupId(utente.getId());
		Iterator<AlbumFotografico> i = albums.iterator();
		while (i.hasNext()) {
			AlbumFotografico alb = i.next();
			int emptyAlbums = emptyAlbumFotografico(alb);
			if (emptyAlbums < 1) {
				removeAlbumFotografico(alb.getId());
			}
		}

	}

}
