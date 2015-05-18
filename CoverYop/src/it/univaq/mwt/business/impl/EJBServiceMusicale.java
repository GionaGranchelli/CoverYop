package it.univaq.mwt.business.impl;

import it.univaq.mwt.business.ServiceMusicaleService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

/**
 * Session Bean implementation class EJBServiceMusicale
 */

@Service
public class EJBServiceMusicale implements ServiceMusicaleService {

	@PersistenceContext(unitName = "Yop-domain")
	private EntityManager em;

	public EJBServiceMusicale() {
		// TODO Auto-generated constructor stub
	}

}
