package it.univaq.mwt.business.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import it.univaq.mwt.business.AlbumFotograficoService;
import it.univaq.mwt.business.FotoService;
import it.univaq.mwt.business.UtenteService;
import it.univaq.mwt.business.model.AlbumFotografico;
import it.univaq.mwt.business.model.Canzone;
import it.univaq.mwt.business.model.Evento;
import it.univaq.mwt.business.model.Foto;
import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.common.utility.FacilityTool;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Session Bean implementation class EJBFoto
 */

@Service
public class EJBFoto implements FotoService {

	@PersistenceContext(unitName = "Yop-domain")
	private EntityManager em;
	
	@Autowired
	AlbumFotograficoService albumFotograficoService;
	
	@Autowired 
	ServletContext servletContext;

	public EJBFoto() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Foto getFotoById(int fotoID) {
		Query query = em
				.createQuery("select f from Foto f where f.id =:fotoID");
		query.setParameter("fotoID", fotoID);
		Foto f = (Foto) query.getSingleResult();
		// Canzone c = new Canzone();
		if (f == null) {
			em.getEntityManagerFactory().getCache().evictAll();
			return new Foto();
		} else {
			em.getEntityManagerFactory().getCache().evictAll();
			return f;
		}

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void deleteFotoById(int fotoID) {
		Foto f = getFotoById(fotoID);
		AlbumFotografico af=f.getAlbumFotografico();
		em.remove(f);
		em.refresh(af);
	}

	@Transactional
	public Foto insertFoto(Foto f) {
		Foto grp = f;
		em.persist(grp);
		em.getEntityManagerFactory().getCache().evictAll();
		return grp;
	}

	@Transactional
	public void insertSetFoto(Set<Foto> setFoto) {
		Iterator<Foto> i = setFoto.iterator();
		while (i.hasNext()) {
			Foto temp = i.next();
			em.merge(temp);
		}
		em.getEntityManagerFactory().getCache().evictAll();
	}

	@Transactional
	public Foto updatePhoto(Foto foto) {
		Foto f = em.merge(foto);
		em.flush();
		return f;
	}

	@Override
	public String getFotoProfiloByUtenteId(int id) {
		Query query = em
				.createQuery("select ft.url from Utente u, AlbumFotografico af, Foto ft where "
						+ "u.id=:id AND af.tag =:profile AND af.utente.id=u.id AND ft.albumFotografico.id=af.id");
		query.setParameter("id", id);
		query.setParameter("profile", "profile");

		List<String> lf = new ArrayList<String>(query.getResultList());
		String fotoProfilo;
		try {
			fotoProfilo = lf.get(0);
		} catch (IndexOutOfBoundsException e) {

			fotoProfilo = "resources/img/animated-noise.gif";

		}
		return fotoProfilo;
	}

	@Override
	public byte[] getFotoProfiloByUtenteIdBlob(int id) {
		Query query = em
				.createQuery("select ft.fotoBlob from Utente u, AlbumFotografico af, Foto ft where "
						+ "u.id=:id AND af.tag =:profile AND af.utente.id=u.id AND ft.albumFotografico.id=af.id");
		query.setParameter("id", id);
		query.setParameter("profile", "profile");
		query.setMaxResults(1);
		byte[] fotoProfilo = null;
		try{
		fotoProfilo = (byte[]) query.getSingleResult();}
		catch(NoResultException e){
			fotoProfilo= FacilityTool.getDefaultImage(servletContext);
			//fotoProfilo
			}
		return fotoProfilo;
//		List<byte[]> lf = new ArrayList<byte[]>(query.getResultList());
//		byte[] fotoProfilo = lf.get(0);
//		return fotoProfilo;
	}

	@Override
	public byte[] getFotoSlideShowByUtenteIdBlob(int id) {
		Query query = em
				.createQuery("select ft.fotoBlob from Utente u, AlbumFotografico af, Foto ft where "
						+ "u.id=:id AND af.tag =:slideshow AND af.utente.id=u.id AND ft.albumFotografico.id=af.id");
		query.setParameter("id", id);
		query.setParameter("slideshow", "slideshow");
		List<byte[]> lf = new ArrayList<byte[]>(query.getResultList());
		byte[] fotoProfilo = lf.get(0);
		return fotoProfilo;
	}

	@Override
	public List<byte[]> getFotoSliderByUtenteIdBlob(int id) {

		Query query = em
				.createQuery("SELECT ft.fotoBlob"
						+ " FROM Foto ft LEFT JOIN"
						+ " (SELECT * FROM Utente u LEFT JOIN AlbumFotografico af ON af.utente.id=u.id)"
						+ " ON ft.albumFotografico.id=af.id"
						+ " WHERE u.id=:id AND af.tag=:slideshow");
		query.setParameter("id", id);
		query.setParameter("slideshow", "slideshow");
		List<byte[]> lf = new ArrayList<byte[]>(query.getResultList());
		return lf;
	}

	@Override
	public AlbumFotografico getAlbumSliderByUserId(int id) {
		Query query = em.createQuery("SELECT af"
				+ " FROM Utente u, AlbumFotografico af"
				+ " WHERE af.utente.id = u.id AND u.id=:idutente"
				+ " AND af.tag=:slider");
		query.setParameter("idutente", id);
		query.setParameter("slider", "slideshow");
		List<AlbumFotografico> a = new ArrayList<AlbumFotografico>(
				query.getResultList());
		return null;
	}

	@Override
	public byte[] getByteFotoById(int id) {
		Query query = em
				.createQuery("select f from Foto f where f.id =:fotoID");
		query.setParameter("fotoID", id);
		Foto f = (Foto) query.getSingleResult();
		byte[] temp = f.getFotoBlob();
		return temp;
	}

	@Transactional
	public void deleteFotoByObj(Foto f) {
		em.remove(f);
		em.getEntityManagerFactory().getCache().evictAll();
	}

}
