package it.univaq.mwt.business.impl;

import java.util.ArrayList;
import java.util.List;

import it.univaq.mwt.business.FotoService;

import it.univaq.mwt.business.model.AlbumFotografico;
import it.univaq.mwt.business.model.Canzone;
import it.univaq.mwt.business.model.Evento;
import it.univaq.mwt.business.model.Foto;
import it.univaq.mwt.business.model.Gruppo;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Session Bean implementation class EJBFoto
 */

@Service
public class EJBFoto implements FotoService {

	@PersistenceContext(unitName = "Yop-domain")
	private EntityManager em;

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
		if (f == null) 
			return new Foto();
		else 
			return f;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void deleteFoto(int fotoID) {
		Foto f = getFotoById(fotoID);
		em.remove(f);

		Query query = em.createQuery("delete from Foto f where f.id =:fotoID");
		query.setParameter("fotoID", fotoID);
		int result = query.executeUpdate();
		em.getEntityManagerFactory().getCache().evict(Foto.class);
	}

	@Transactional
	public Foto insertFoto(Foto f) {
		Foto grp = f;
		em.persist(grp);
		return grp;
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
		
		//byte[] fotoProfilo = null;
		
		List<byte[]> lf = new ArrayList<byte[]>(query.getResultList());
		byte[] fotoProfilo = lf.get(0);
		
//		if(query.getSingleResult().equals(null)){		
//		 fotoProfilo  = (byte[]) query.getSingleResult(); //inserire controllo se immagine non c'è
//		}
		//inserire avatar default 

		return fotoProfilo;
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
		
//		select ft.fotoBlob from Utente u, AlbumFotografico af, Foto ft 
//		where u.user_id= 63
//		AND af.tag = 'slider'
//		AND af.utente_user_id=u.user_id 
//		AND ft.albumFotograficoid=af.id;
//		 AND af.utente=u AND ft.albumFotografico =af
		Query query = em
				.createQuery("SELECT ft.fotoBlob"
							+ " FROM Foto ft LEFT JOIN"
							+ " (SELECT * FROM Utente u LEFT JOIN AlbumFotografico af ON af.utente.id=u.id)"
							+ " ON ft.albumFotografico.id=af.id"
							+ " WHERE u.id=:id AND af.tag=:slider");
		
		query.setParameter("id", id);
		query.setParameter("slider", "slider");
		
		System.out.println("sono dentro ejb");

		List<byte[]> lf = new ArrayList<byte[]>(query.getResultList());
		//byte[] fotoProfilo = lf.get(0);
		System.out.println("Size = " + lf.size());

		return lf;
	}

	@Override
	public AlbumFotografico getAlbumSliderByUserId(int id) {
		Query query = em.createQuery("SELECT af"
									+" FROM Utente u, AlbumFotografico af"
									+" WHERE af.utente.id = u.id AND u.id=:idutente"
									+" AND af.tag=:slider");
		query.setParameter("idutente", id);
		query.setParameter("slider", "slider");
		List<AlbumFotografico> a = new ArrayList<AlbumFotografico>(query.getResultList());
		
		System.out.println("Albumid = " + a.size());
		return null;
	}

	@Override
	public byte[] getByteFotoById(int id) {
		Query query = em
				.createQuery("select f from Foto f where f.id =:fotoID");
		query.setParameter("fotoID", id);
		Foto f = (Foto) query.getSingleResult();
		// Canzone c = new Canzone();
		byte[] temp = f.getFotoBlob();
		return temp;
	}
	
	
}
