package it.univaq.mwt.business.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import it.univaq.mwt.business.LocaleService;

import it.univaq.mwt.business.model.AlbumFotografico;
import it.univaq.mwt.business.model.Categoria;
import it.univaq.mwt.business.model.Foto;
import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.business.model.Locale;

import it.univaq.mwt.business.model.Utente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Session Bean implementation class EJBLocale
 */

@Service
public class EJBLocale implements LocaleService {

	@PersistenceContext(unitName = "Yop-domain")
	private EntityManager em;

	public EJBLocale() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Locale> findAllLocali() {
		em.clear();
		Query query = em
				.createQuery("select l "
						+ "from Locale l, Utente u, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te");
		List<Locale> resultList = (List<Locale>) query.getResultList();
		return resultList;
	}

	@Override
	public Locale findLocaleById(int localeID) {

		Query query = em.createQuery("select lc "
				+ "from Locale lc, Evento ev, Gruppo g, AlbumFotografico af "
				+ "where lc.id =:localeID");
		query.setParameter("localeID", localeID);
		Locale result = (Locale) query.getSingleResult();
		if (result == null) {
			return new Locale();
		}
		return result;

	}

	@Override
	@Transactional
	public Locale createLocale(Locale locale) {
		Locale lcl = locale;
		em.persist(lcl);
		return lcl;
	}

	@Override
	public List<Locale> findLocaleByName(String locale) {

		String localeToLower = locale.toLowerCase();

		Query query = em.createQuery("select lc " + "from Locale lc "
				+ "where lower(lc.nomeLocale) LIKE :localeLow");
		query.setParameter("localeLow", "%" + localeToLower + "%");

		List<Locale> locali = new ArrayList<Locale>(query.getResultList());
		return locali;
	}

	@Override
	public List<Locale> customSearchLocali(String nomeLocale, String citta,
			String tipologia) {
		String queryString = null;
		List<Locale> lista = null;
		Query query = null;
		if (nomeLocale == null && citta == null && tipologia == null) {
			lista = findAllLocali();
			return lista;
		}
		if (!(nomeLocale.isEmpty()) && !(citta.isEmpty()) && !(tipologia.isEmpty())) {

			queryString = "select l "
					+ "from Locale l, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where "
					+ "lower(l.nomeLocale) LIKE :nomel AND lower(l.citta) LIKE :citta AND lower(l.categoria.nomeCat) LIKE :tipologia";
			query = em.createQuery(queryString);
			String nomeLow = nomeLocale;
			String cittaLow = citta.toLowerCase();
			String tipologiaLow = tipologia.toLowerCase();
			query.setParameter("nomel", "%" + nomeLow + "%");
			query.setParameter("citta", "%" + cittaLow + "%");
			query.setParameter("tipologia", "%" + tipologiaLow + "%");
		} else if (!(nomeLocale.isEmpty()) && !(citta.isEmpty())) {
			queryString = "select l "
					+ "from Locale l, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where "
					+ "lower(l.nomeLocale) LIKE :nomel AND lower(l.citta) LIKE :citta AND lower(l.categoria.nomeCat) LIKE :tipologia";
			query = em.createQuery(queryString);
			String nomeLow = nomeLocale;
			String cittaLow = citta.toLowerCase();
			query.setParameter("nomel", "%" + nomeLow + "%");
			query.setParameter("citta", "%" + cittaLow + "%");
		} else if (!(citta.isEmpty()) && !(tipologia.isEmpty())) {
			queryString = "select l "
					+ "from Locale l, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where "
					+ "lower(l.citta) LIKE :citta AND lower(l.categoria.nomeCat) LIKE :tipologia";
			query = em.createQuery(queryString);
			String cittaLow = citta.toLowerCase();
			String tipologiaLow = tipologia.toLowerCase();
			query.setParameter("citta", "%" + cittaLow + "%");
			query.setParameter("tipologia", "%" + tipologiaLow + "%");
		} else if (!(nomeLocale.isEmpty()) && !(tipologia.isEmpty())) {
			queryString = "select l "
					+ "from Locale l, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where "
					+ "lower(l.nomeLocale) LIKE :nomel AND lower(l.categoria.nomeCat) LIKE :tipologia";
			query = em.createQuery(queryString);
			String nomeLow = nomeLocale;
			String tipologiaLow = tipologia.toLowerCase();
			query.setParameter("nomel", "%" + nomeLow + "%");
			query.setParameter("tipologia", "%" + tipologiaLow + "%");
		} else if (!(nomeLocale.isEmpty())) {

			queryString = "select l "
					+ "from Locale l, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where "
					+ "lower(l.nomeLocale) LIKE :nomel";
			query = em.createQuery(queryString);
			String nomeLow = nomeLocale.toLowerCase();
			query.setParameter("nomel", "%" + nomeLow + "%");

		} else if (!(citta.isEmpty())) {

			queryString = "select l "
					+ "from Locale l, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where "
					+ "lower(l.citta) LIKE :citta";
			query = em.createQuery(queryString);
			String cittaLow = citta.toLowerCase();
			query.setParameter("citta", "%" + cittaLow + "%");
		} else if (!(tipologia.isEmpty())) {

			queryString = "select l "
					+ "from Locale l, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where "
					+ "lower(l.categoria.nomeCat) LIKE :tipologia";
			query = em.createQuery(queryString);
			String tipologiaLow = tipologia.toLowerCase();
			query.setParameter("tipologia", "%" + tipologiaLow + "%");
		}
		List<Locale> risultatoListaLocali = (List<Locale>) query.getResultList();

		return risultatoListaLocali;
	}

	@Override
	public Locale findLocaleByUser(Utente u) {
		Locale n = em.find(Locale.class, u.getId());
		return n;
	}

	@Override
	public List<Categoria> getAllCategorieByLocali(List locali) {
		Query query = em.createQuery("select l.categoria " + "from Locale l ");
		List<Categoria> categorie = new ArrayList<Categoria>(query.getResultList());
		return categorie;
	}

	@Transactional
	public Locale update(Locale l) {
		Locale n = em.merge(l);
		em.flush();
		return n;
	}

	@Override
	public List<Locale> findlastSubscribed(int i) {
		String queryString = "select l from Locale l ORDER BY l.id";
		Query query = em.createQuery(queryString);
		query.setMaxResults(i);
		List<Locale> result = (List<Locale>) query.getResultList();
		return result;
	}

	@Override
	public Locale findLocaleByCoord(String nomeLocale, String indirizzo, String citta) {

		String queryString = "select l from Locale l where lower(l.nomeLocale) LIKE :nomeLocale AND lower(l.indirizzo) LIKE :indirizzo AND lower(l.citta) LIKE :citta";
		Query query = em.createQuery(queryString);
		query.setParameter("nomeLocale", "%" + nomeLocale.toLowerCase() + "%");
		query.setParameter("indirizzo", "%" + indirizzo.toLowerCase() + "%");
		query.setParameter("citta", "%" + citta.toLowerCase() + "%");
		List result = query.getResultList();
		Locale locale = (Locale) result.get(0);
		return locale;
	}

	@Override
	public void buildInfoLocale(Utente utente, Locale viewLocale, Locale locale) {
		viewLocale = em.find(Locale.class, utente.getId());
		buildInfoLocale(viewLocale, locale);

	}

	@Override
	public void buildInfoLocale(Locale viewLocale, Locale locale) {
		viewLocale.setNomeLocale(locale.getNomeLocale());
		viewLocale.setCitta(locale.getCitta());
		viewLocale.setIndirizzo(locale.getIndirizzo());
		viewLocale.setOrarioApertura(locale.getOrarioApertura());
		viewLocale.setOrarioChiusura(locale.getOrarioChiusura());
		viewLocale.setCategoria(locale.getCategoria());
		viewLocale.setDescrizione(locale.getDescrizione());
		viewLocale.setCanale(locale.getCanale());
		viewLocale.setService(locale.getService());

	}

	@Override
	public void buildInfoUtente(Locale l, Locale locale) {
		l.setNome(locale.getNome());
		l.setCitta(locale.getCitta());
		l.setTelefono(locale.getTelefono());
		l.setUsername(locale.getUsername());
		l.setEmail(locale.getEmail());
		l.setPassword(locale.getPassword());

	}

	@Override
	public Foto addPhotoProfile(Locale l, Foto f) {

		Set<AlbumFotografico> allPhotoAlbums = l.getAlbumFotografico();
		Iterator<AlbumFotografico> i = allPhotoAlbums.iterator();
		while (i.hasNext()) {
			AlbumFotografico temp = i.next();
			if (temp.getTag().equals("profile")) {
				f.setAlbumFotografico(temp);
				Set<Foto> fotoDaCancellare = temp.getFoto();
				Iterator j = fotoDaCancellare.iterator();
				while(j.hasNext()){
					
				}
				temp.addFoto(f);
			}
		}
		return f;
	}
}
