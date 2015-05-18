package it.univaq.mwt.business.impl;

import it.univaq.mwt.business.GenereService;
import it.univaq.mwt.business.model.Genere;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

/**
 * Session Bean implementation class EJBGenere
 */

@Service
public class EJBGenere implements GenereService {

	@PersistenceContext(unitName = "Yop-domain")
	private EntityManager em;

	public EJBGenere() {
		// TODO Auto-generated constructor stub
	}

	public List<Genere> findAllGeneri() {
		Query query = em.createQuery("select gn " + "from Genere gn");

		List<Genere> result = new ArrayList<Genere>(query.getResultList());

		return result;

	}

	@Override
	public List<String> findAllGeneriTitoli() {
		Query query = em.createQuery("select gn " + "from Genere gn");

		List<Genere> result = new ArrayList<Genere>(query.getResultList());

		Iterator<Genere> i = result.iterator();
		List<String> generi = new ArrayList<String>();
		while (i.hasNext()) {
			Genere temp = i.next();
			generi.add(temp.getGenere());
		}
		return generi;
	}

	public Genere getGenereById(int Id) {
		Genere a = em.find(Genere.class, Id);
		return a;
	}
}
