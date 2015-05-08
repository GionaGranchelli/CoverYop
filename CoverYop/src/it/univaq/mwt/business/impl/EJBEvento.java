package it.univaq.mwt.business.impl;

import it.univaq.mwt.business.EventoService;
import it.univaq.mwt.business.GruppoService;
import it.univaq.mwt.business.model.Evento;
import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.business.model.Locale;
import it.univaq.mwt.business.model.TipologiaEvento;
import it.univaq.mwt.common.utility.SaveFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletContext;

import org.eclipse.persistence.sessions.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Session Bean implementation class EJBEvento
 */

@Service
public class EJBEvento implements EventoService {

	@PersistenceContext(unitName = "Yop-domain")
	private EntityManager em;

	@Autowired
	GruppoService gruppoService;
	@Autowired
	ServletContext servletContext;
	public EJBEvento() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<Evento> findGruppoByEvent(Set<Evento> eventi) {

		Set<Evento> result = new HashSet<Evento>();

		for (Iterator iterator = eventi.iterator(); iterator.hasNext();) {
			Set<Gruppo> gruppi = new HashSet<Gruppo>();
			Evento evento = (Evento) iterator.next();
			Query query = null;
			query = em.createQuery("select  gr " + "from Evento ev, Gruppo gr  "
					+ "where ev.id =:eventoID");
			query.setParameter("eventoID", evento.getId());
			List<Gruppo> lista = new ArrayList<Gruppo>();
			lista = (List<Gruppo>) query.getResultList();

			for (Iterator iterator2 = lista.iterator(); iterator2.hasNext();) {
				Gruppo gruppo = (Gruppo) iterator2.next();
				gruppi.add(gruppo);
			}
			evento.setGruppo(gruppi);
			System.out.println();
			result.add(evento);
		}

		return result;

	}

	@Override
	public List<Evento> findAllEventi() {
		em.clear();
		Query query = em
				.createQuery("select e "
						+ "from Evento e, Gruppo g, Tour t, TipologiaEvento te where e.status > 10");
		// + " where e.id =: g.id");

		List<Evento> resultList = (List<Evento>) query.getResultList();
		em.getEntityManagerFactory().getCache().evictAll();
		return resultList;
	}

	@Override
	public Evento findEventoById(int id) {

		em.clear();
		Query query = em.createQuery("select e "
				+ "from Evento e, Gruppo g, Tour t, TipologiaEvento te "
				+ "where e.id =:id");
		query.setParameter("id", id);

		Evento result = (Evento) query.getSingleResult();
		em.getEntityManagerFactory().getCache().evictAll();
		return result;

	}

	@Transactional
	public Evento updateEvent(Evento v) {
		// TODO Auto-generated method stub
		Evento ev = em.merge(v);
		em.flush();
		return ev;
	}

	@Override
	public List<Evento> CustomSearchEventi(String nomeEvento, String tipologiaEvento,
			String luogo) {
		String queryString = null;
		Query query = null;
		if ((nomeEvento == null) && (tipologiaEvento == null) && (luogo == null)) {
			return findAllEventi();
		}
		if (!(nomeEvento.isEmpty()) && !(luogo.isEmpty()) && !(tipologiaEvento.isEmpty())) {
			queryString = "select e from Evento e, Gruppo g, Genere gn, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where e.status > 10 AND  lower(e.nome) LIKE :nomeE AND lower(e.luogo) LIKE :luogo AND lower(e.tipologia_Eventi.nome) LIKE :tipologiaEvento";
			query = em.createQuery(queryString);
			String nomeLow = nomeEvento;
			String luogoLow = luogo.toLowerCase();
			String tipologiaEventoLow = tipologiaEvento.toLowerCase();
			query.setParameter("nomeE", "%" + nomeLow + "%");
			query.setParameter("luogo", "%" + luogoLow + "%");
			query.setParameter("tipologiaEvento", "%" + tipologiaEventoLow + "%");
		} else if (!(nomeEvento.isEmpty()) && !(luogo.isEmpty())) {
			queryString = "select e from Evento e, Gruppo g, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where e.status > 10 AND  lower(e.nome) LIKE :nomeE AND lower(e.luogo) LIKE :luogo";
			query = em.createQuery(queryString);
			String nomeLow = nomeEvento;
			String luogoLow = luogo.toLowerCase();
			query.setParameter("nomeE", "%" + nomeLow + "%");
			query.setParameter("luogo", "%" + luogoLow + "%");
		} else if (!(luogo.isEmpty()) && !(tipologiaEvento.isEmpty())) {
			queryString = "select e from Evento e, Gruppo g, Genere gn, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where e.status > 10 AND  lower(e.luogo) LIKE :luogo AND lower(e.tipologia_Eventi.nome) LIKE :tipologiaEvento";
			query = em.createQuery(queryString);
			String luogoLow = luogo.toLowerCase();
			String tipologiaEventoLow = tipologiaEvento.toLowerCase();
			query.setParameter("luogo", "%" + luogoLow + "%");
			query.setParameter("tipologiaEvento", "%" + tipologiaEventoLow + "%");
		} else if (!(nomeEvento.isEmpty()) && !(tipologiaEvento.isEmpty())) {
			queryString = "select e from Evento e, Gruppo g, Genere gn, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where e.status > 10 AND  lower(e.nome) LIKE :nomeE AND lower(e.tipologia_Eventi.nome) LIKE :tipologiaEvento";
			query = em.createQuery(queryString);
			String nomeLow = nomeEvento;
			String tipologiaEventoLow = tipologiaEvento.toLowerCase();
			query.setParameter("nomeE", "%" + nomeLow + "%");
			query.setParameter("tipologiaEvento", "%" + tipologiaEventoLow + "%");
		} else if (!(nomeEvento.isEmpty())) {

			queryString = "select e from Evento e, Gruppo g, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where e.status > 10 AND  lower(e.nome) LIKE :nomeE";
			query = em.createQuery(queryString);
			String nomeLow = nomeEvento.toLowerCase();
			query.setParameter("nomeE", "%" + nomeLow + "%");

		} else if (!(luogo.isEmpty())) {

			queryString = "select e from Evento e, Gruppo g, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where e.status > 10 AND  lower(e.luogo) LIKE :luogo";
			query = em.createQuery(queryString);
			String luogoLow = luogo.toLowerCase();
			query.setParameter("luogo", "%" + luogoLow + "%");
		} else if (!(tipologiaEvento.isEmpty())) {

			queryString = "select e from Evento e, Gruppo g, Genere gn, AlbumFotografico al, Foto f, Tour t, TipologiaEvento te where e.status > 10 AND lower(e.tipologia_Eventi.nome) LIKE :tipologiaEvento";
			query = em.createQuery(queryString);
			String tipologiaEventoLow = tipologiaEvento.toLowerCase();
			query.setParameter("tipologiaEvento", "%" + tipologiaEventoLow + "%");
		}

		List<Evento> lista = (List<Evento>) query.getResultList();
		return lista;
	}

	@Override
	public List<Evento> findEventoByName(String nome) {
		String eventoToLower = nome.toLowerCase();

		Query queryE = em.createQuery("select DISTINCT evn" + " from Evento evn"
				+ " where lower(evn.nome) LIKE :nomeE;");

		queryE.setParameter("nomeE", "%" + eventoToLower + "%");
		List<Evento> result = queryE.getResultList();
		return result;

	}

	public byte[] getImmagineEvento(int id) {
		em.clear();
		Query query = em.createQuery("select e "
				+ "from Evento e, Gruppo g, Tour t, TipologiaEvento te "
				+ "where e.id =:id");
		query.setParameter("id", id);

		Evento result = (Evento) query.getSingleResult();
		byte[] immagine = result.getLocandinaBlob();
		em.getEntityManagerFactory().getCache().evictAll();
		return immagine;

	}

	@Override
	public Evento buildEventoInfo(Evento evento, Locale locale, Gruppo gruppo,
			TipologiaEvento tipoEvento, CommonsMultipartFile immagine) {
		Evento result = evento;
		Set<Gruppo> listaGruppi = new HashSet<Gruppo>();
		gruppo.addEvento(result);
		listaGruppi.add(gruppo);
		result.setGruppo(listaGruppi);
		result.setLocandinaBlob(immagine.getBytes());
		result.setTipologia_Eventi(tipoEvento);
		result.setLocale(locale);
		result.setStatus(10);
		return result;
	}

	@Transactional
	public Evento insertEvento(Evento evento) {
		Evento ev = evento;
		em.persist(ev);

		return ev;
	}

	@Override
	public Evento buildEventForUpdate(Evento evento, Locale locale, String nomeGruppo,
			TipologiaEvento tipoEvento, CommonsMultipartFile immagine) {
		// Ottengo l'evento Originale che si vuole Modficare
		Evento eventoOrginale = findEventoById(evento.getId());
		// Asseggno ad toUpdateEvent, l'oggetto evento ottenuto dalla form
		Evento toUpdateEvent = evento;
		// Controllo se è stato Cambiato il Gruppo che suonerà all'Evento
		if (nomeGruppo != null) {
			// Ottengo la Lista dei Gruppi da Rimuovere
			// NB Per semplicità Al Momento nonostante si può possono inserire
			// più gruppi, utilizzeremo gli eventi come se avessero un solo
			// gruppo
			Set<Gruppo> listaGruppiDaRimuovere = eventoOrginale.getGruppo();
			// Per Ogni Gruppo gli rimuovo l'evento di riferimento
			Iterator<Gruppo> i = listaGruppiDaRimuovere.iterator();
			while (i.hasNext()) {
				Gruppo gruppoDaEliminareDallEvento = i.next();
				gruppoDaEliminareDallEvento.removeEvento(eventoOrginale);
				gruppoService.update(gruppoDaEliminareDallEvento);
			}

			Set<Gruppo> listaGruppiDaInserire = new HashSet<Gruppo>();
			Gruppo gruppoScelto = gruppoService.findGruppoByCorrectName(nomeGruppo);

			gruppoScelto.addEvento(toUpdateEvent);
			listaGruppiDaInserire.add(gruppoScelto);
			toUpdateEvent.setGruppo(listaGruppiDaInserire);
		}
		System.out.println(servletContext.getRealPath("/resources/placeholders/artist01.jpg"));
		if (immagine.getSize() != 0) {
			toUpdateEvent.setLocandinaBlob(immagine.getBytes());
		} else {
			// Se non è stata inserita
			System.out.println("Sono in primo Else");
			System.out.println("eventoOrginale.getLocandinaBlob() "
					+ eventoOrginale.getLocandinaBlob());
			if (eventoOrginale.getLocandinaBlob() != null) {
				toUpdateEvent.setLocandinaBlob(eventoOrginale.getLocandinaBlob());
			} else {
				try {
					System.out.println("sono qui");
					
							System.out.println(servletContext.getRealPath("/resources/placeholders/artist01.jpg"));
					toUpdateEvent.setLocandinaBlob(SaveFile
							.extractBytes(servletContext.getRealPath(
									"/resources/placeholders/artist01.jpg")));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		toUpdateEvent.setTipologia_Eventi(tipoEvento);
		toUpdateEvent.setLocale(locale);
		return toUpdateEvent;
	}

}
