package it.univaq.mwt.business.impl;

import it.univaq.mwt.business.TourService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

/**
 * Session Bean implementation class EJBTour
 */

@Service
public class EJBTour implements TourService {

	@PersistenceContext(unitName = "Yop-domain")
	private EntityManager em;

	public EJBTour() {
		// TODO Auto-generated constructor stub
	}

}
