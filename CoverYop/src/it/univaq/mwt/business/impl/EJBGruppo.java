package it.univaq.mwt.business.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

import it.univaq.mwt.business.GenereService;
import it.univaq.mwt.business.GruppoDiRiferimentoService;
import it.univaq.mwt.business.GruppoService;
import it.univaq.mwt.business.model.Album;
import it.univaq.mwt.business.model.Evento;
import it.univaq.mwt.business.model.Genere;
import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.business.model.GruppoDiRiferimento;
import it.univaq.mwt.business.model.Locale;
import it.univaq.mwt.business.model.Utente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Session Bean implementation class EJBGruppo
 */

@Service
public class EJBGruppo implements GruppoService {

	@PersistenceContext(unitName = "Yop-domain")
	private EntityManager em;
	
	@Autowired
	GenereService genereServ;
	
	@Autowired
	GruppoDiRiferimentoService gruppoRifServ;

	public EJBGruppo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Gruppo> findAllGruppi() {
		em.clear();
		Query query = em
				.createQuery("select g "
						+ "from Gruppo g, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te");
		// + " where e.id =: g.id");

		List<Gruppo> resultList = (List<Gruppo>) query.getResultList();
		return resultList;
	}

	@Override
	public Gruppo findGruppoById(int id) {
		Gruppo result = em.find(Gruppo.class, id);
		if (result == null) {
			result = new Gruppo();
		}
		return result;
	}

	public Gruppo findGruppoByUtente(Utente u) {
		Gruppo g = em.find(Gruppo.class, u.getId());
		return g;
	}

	@Override
	public Gruppo findGruppoByPosition(float lat, float lng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public Gruppo update(Gruppo gruppo) {
		Gruppo g = em.merge(gruppo);
		return g;
	}

	@Override
	@Transactional
	public Gruppo createGruppo(Gruppo gruppo) {
		Gruppo grp = gruppo;
		em.persist(grp);
		return grp;
	}

	@Override
	public List<Gruppo> customSearchGruppi(String nomeGruppo, String citta, String genere) {
		String queryString = null;
		List<Gruppo> result;
		Query query = null;
		if(nomeGruppo == null && citta == null && genere == null){
			result = findAllGruppi();
			return result;
		}
		if (!(nomeGruppo.isEmpty()) && !(citta.isEmpty()) && !(genere.isEmpty())) {

			queryString = "select g from Gruppo g, Genere gn, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where lower(g.nomeGruppo) LIKE :nomeg AND lower(g.citta) LIKE :citta AND lower(gn.genere) LIKE :genere";
			query = em.createQuery(queryString);
			String nomeLow = nomeGruppo;
			String cittaLow = citta.toLowerCase();
			String genereLow = genere.toLowerCase();
			query.setParameter("nomeg", "%" + nomeLow + "%");
			query.setParameter("citta", "%" + cittaLow + "%");
			query.setParameter("genere", "%" + genereLow + "%");
		} else if (!(nomeGruppo.isEmpty()) && !(citta.isEmpty())) {
			queryString = "select g from Gruppo g, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where lower(g.nomeGruppo) LIKE :nomeg AND lower(g.citta) LIKE :citta";
			query = em.createQuery(queryString);
			String nomeLow = nomeGruppo;
			String cittaLow = citta.toLowerCase();
			query.setParameter("nomeg", "%" + nomeLow + "%");
			query.setParameter("citta", "%" + cittaLow + "%");
		} else if (!(citta.isEmpty()) && !(genere.isEmpty())) {
			queryString = "select g from Gruppo g, Genere gn, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where lower(g.citta) LIKE :citta AND lower(gn.genere) LIKE :genere";
			query = em.createQuery(queryString);
			String cittaLow = citta.toLowerCase();
			String genereLow = genere.toLowerCase();
			query.setParameter("citta", "%" + cittaLow + "%");
			query.setParameter("genere", "%" + genereLow + "%");
		} else if (!(nomeGruppo.isEmpty()) && !(genere.isEmpty())) {
			queryString = "select g from Gruppo g, Genere gn, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where lower(g.nomeGruppo) LIKE :nomeg AND lower(gn.genere) LIKE :genere";
			query = em.createQuery(queryString);
			String nomeLow = nomeGruppo;
			String genereLow = genere.toLowerCase();
			query.setParameter("nomeg", "%" + nomeLow + "%");
			query.setParameter("genere", "%" + genereLow + "%");
		} else if (!(nomeGruppo.isEmpty())) {

			queryString = "select g from Gruppo g, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where lower(g.nomeGruppo) LIKE :nomeGruppo";
			query = em.createQuery(queryString);
			String nomeLow = nomeGruppo.toLowerCase();
			query.setParameter("nomeGruppo", "%" + nomeLow + "%");

		} else if (!(citta.isEmpty())) {

			queryString = "select g from Gruppo g, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where lower(g.citta) LIKE :citta";
			query = em.createQuery(queryString);
			String cittaLow = citta.toLowerCase();
			query.setParameter("citta", "%" + cittaLow + "%");
		} else if (!(genere.isEmpty())) {

			queryString = "select g from Gruppo g, Genere gn, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where lower(gn.genere) LIKE :genere";
			query = em.createQuery(queryString);
			String genereLow = genere.toLowerCase();
			query.setParameter("genere", "%" + genereLow + "%");
		} else {
			return findAllGruppi();
		}

		List<Gruppo> lista = (List<Gruppo>) query.getResultList();
		

		return lista;
	}

	@Override
	public List<Gruppo> findGruppoByName(String name) {
		String gruppoToLower = name.toLowerCase();

		Query query = em.createQuery("select lc " + "from Gruppo lc "
				+ "where lower(lc.nomeGruppo) LIKE :localeLow");
		query.setParameter("localeLow", "%" + gruppoToLower + "%");

		List<Gruppo> gruppi = new ArrayList<Gruppo>(query.getResultList());
		return gruppi;
	}

	@Override
	public List<Gruppo> findLastSubscribed(int i) {
		String queryString = "select grp from Gruppo grp ORDER BY grp.id DESC";
		Query query = em.createQuery(queryString).setMaxResults(i);
		List<Gruppo> result = (List<Gruppo>) query.getResultList();
		return result;
	}

	@Override
	public Gruppo findGruppoByCoord(String nomeGruppo, String citta) {
		String queryString = "select grp from Gruppo grp where lower(grp.nomeGruppo) LIKE :nomeGruppo AND lower(grp.citta) LIKE :citta";
		Query query = em.createQuery(queryString);
		query.setParameter("nomeGruppo", "%" + nomeGruppo.toLowerCase() + "%");
		query.setParameter("citta", "%" + citta.toLowerCase() + "%");
		List result = query.getResultList();
		Gruppo gruppo = (Gruppo) result.get(0);
		return gruppo;
	}

	@Override
	public List<Utente> SearchUsers(String nome) {
		String gruppoToLower = nome.toLowerCase();

		Query query = em.createQuery("select DISTINCT grp" + " from Gruppo grp"
				+ " where lower(grp.nomeGruppo) LIKE :nomeG;");
		query.setParameter("nomeG", "%" + gruppoToLower + "%");
		List<Utente> result = query.getResultList();
		result.addAll(SearchUsers2(nome));
		return result;
	}

	public List<Utente> SearchUsers2(String nome) {
		String localeToLower = nome.toLowerCase();

		Query queryl = em.createQuery("select DISTINCT lcl" + " from Locale lcl"
				+ " where lower(lcl.nomeLocale) LIKE :nomeL;");

		queryl.setParameter("nomeL", "%" + localeToLower + "%");
		List<Utente> resultL = queryl.getResultList();
		return resultL;
	}

	@Override
	public void buildGroupInfo(Gruppo viewGroup, Gruppo gruppo) {
		viewGroup.setCachet(gruppo.getCachet());
		viewGroup.setCitta(gruppo.getCitta());
		viewGroup.setNomeGruppo(gruppo.getNomeGruppo());
		viewGroup.setBiografia(gruppo.getBiografia());
		viewGroup.setCanale(gruppo.getCanale());
		viewGroup.setService(gruppo.getService());
		viewGroup.setCover_Band(gruppo.getCover_Band());
		if(gruppo.getGeneri() != null){
			Set<Genere> asd = gruppo.getGeneri();
			Iterator<Genere> i = asd.iterator();
			while(i.hasNext()){
				Genere a = new Genere();
				Genere temp = new Genere();
				a = i.next();
				temp = genereServ.getGenereById(Integer.parseInt(a.getGenere()));
				viewGroup.addGenere(temp);
			}
		}
		if(gruppo.getGruppi_rif() != null){
			Set<GruppoDiRiferimento> rif = gruppo.getGruppi_rif();
			Iterator<GruppoDiRiferimento> j = rif.iterator();
			while(j.hasNext()){
				GruppoDiRiferimento a = new GruppoDiRiferimento();
				GruppoDiRiferimento temp = new GruppoDiRiferimento();
				a = j.next();
				temp = gruppoRifServ.getGruppiDiRiferimentoById((Integer.parseInt(a.getNome())));
				viewGroup.addGruppi_rif(temp);
			}
		}
		
	}

}
