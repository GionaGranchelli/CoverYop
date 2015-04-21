package it.univaq.mwt.business.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.univaq.mwt.business.LocaleService;



import it.univaq.mwt.business.model.Categoria;
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

	@PersistenceContext(unitName="Yop-domain")
	private EntityManager em;
	
	
    public EJBLocale() {
        // TODO Auto-generated constructor stub
    }


//	@Override
//	public List<Locale> findAllLocali() {
//		System.out.println("Sono Entrato");
//		Query query = em.createQuery("select lt from Locale lt");
//		
//		List<Locale> locali = new ArrayList<Locale>(query.getResultList());
//		System.out.println("asd" + locali.size());
//		return locali;
//	}
	
    @Override
	public Set<Locale> findAllLocali() {
	em.clear();
	Query query = em.createQuery("select l "
			+ "from Locale l, Utente u, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te");
			
	
	List<Locale> resultList = (List<Locale>) query.getResultList();
	Set <Locale> result =  new HashSet<Locale>(resultList);
	em.getEntityManagerFactory().getCache().evictAll();
	return result;
	}


	@Override
	public Locale findLocaleById(int localeID) {
		
		Query query = em.createQuery("select lc "
				+ "from Locale lc, Evento ev, Gruppo g, AlbumFotografico af "
				+ "where lc.id =:localeID");
		query.setParameter("localeID", localeID);
		
	
		Locale result = (Locale) query.getSingleResult();
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
		
		Query query = em.createQuery("select lc "
				+ "from Locale lc "
				+ "where lower(lc.nomeLocale) LIKE :localeLow");
		query.setParameter("localeLow", "%" +localeToLower + "%");
		
		List<Locale> locali = new ArrayList<Locale>(query.getResultList());
		return locali;
	}


	@Override
	public Set<Locale> customSearchLocali(String nomeLocale, String citta,
			String tipologia) {
		
		
		String queryString = null;
		
		Query query = null;
		if (!(nomeLocale.isEmpty()) && !(citta.isEmpty()) && !(tipologia.isEmpty())){
				
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
			}else if (!(nomeLocale.isEmpty()) && !(citta.isEmpty())){
				queryString = "select l "
						+ "from Locale l, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where "
						+ "lower(l.nomeLocale) LIKE :nomel AND lower(l.citta) LIKE :citta AND lower(l.categoria.nomeCat) LIKE :tipologia";
				query = em.createQuery(queryString);			
				String nomeLow = nomeLocale;
				String cittaLow = citta.toLowerCase();
				query.setParameter("nomel", "%" + nomeLow + "%");
				query.setParameter("citta", "%" + cittaLow + "%");
			}else if (!(citta.isEmpty()) && !(tipologia.isEmpty())){
				queryString = "select l "
						+ "from Locale l, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where "
						+ "lower(l.citta) LIKE :citta AND lower(l.categoria.nomeCat) LIKE :tipologia";
				query = em.createQuery(queryString);
				String cittaLow = citta.toLowerCase();
				String tipologiaLow = tipologia.toLowerCase();
				query.setParameter("citta", "%" + cittaLow + "%");
				query.setParameter("tipologia", "%" + tipologiaLow + "%");
			}else if (!(nomeLocale.isEmpty()) && !(tipologia.isEmpty())){
				queryString = "select l "
						+ "from Locale l, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where "
						+ "lower(l.nomeLocale) LIKE :nomel AND lower(l.categoria.nomeCat) LIKE :tipologia";
				query = em.createQuery(queryString);
				String nomeLow = nomeLocale;
				String tipologiaLow = tipologia.toLowerCase();
				query.setParameter("nomel", "%" + nomeLow + "%");
				query.setParameter("tipologia", "%" + tipologiaLow + "%");
			}else if(!(nomeLocale.isEmpty())){
				
				queryString = "select l "
						+ "from Locale l, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where "
						+ "lower(l.nomeLocale) LIKE :nomel";
				query = em.createQuery(queryString);
				String nomeLow = nomeLocale.toLowerCase();
				query.setParameter("nomel", "%"+nomeLow+"%");
				
			}else if ( !(citta.isEmpty())){
				
				queryString = "select l "
						+ "from Locale l, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where "
						+ "lower(l.citta) LIKE :citta";
				query = em.createQuery(queryString);
				String cittaLow = citta.toLowerCase();
				query.setParameter("citta", "%" + cittaLow + "%");
			}else if ( !(tipologia.isEmpty())){
				
				queryString = "select l "
						+ "from Locale l, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where "
						+ "lower(l.categoria.nomeCat) LIKE :tipologia";
				query = em.createQuery(queryString);
				String tipologiaLow = tipologia.toLowerCase();
				query.setParameter("tipologia", "%" + tipologiaLow + "%");
			}	
			
			
			
			
			
			
			List<Locale> lista = (List<Locale>) query.getResultList();
			Set<Locale> result = new HashSet<Locale>(lista);
			

			return result;
		
		
//		String nomeLow = nomeLocale.toLowerCase();
//		String tip = tipologia.toLowerCase();
//		Query query = em.createQuery("select lc from Locale lc  where lower(lc.categoria.nomeCat) LIKE :nomeCat");
//		query.setParameter("nomeCat", tip);
//		List<Locale> lista = query.getResultList();
//		Set<Locale> result = new HashSet<Locale>(lista);
//		return result;
	}
	@Override
	public Locale findLocaleByUser(Utente u) {
		Locale n = em.find(Locale.class, u.getId());
		return n;
	}
	

	@Override
	public List<Categoria> getAllCategorieByLocali(List locali) {
		Query query = em.createQuery("select l.categoria "
				+ "from Locale l ");
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
	public List findlastSubscribed(int i) {
		String queryString = "select l from Locale l ORDER BY l.id";
		Query query = em.createQuery(queryString);
		query.setMaxResults(i);
		List result = query.getResultList();
		return result;
	}
}
