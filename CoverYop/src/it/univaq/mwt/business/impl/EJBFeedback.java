package it.univaq.mwt.business.impl;

import it.univaq.mwt.business.FeedbackService;





import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

/**
 * Session Bean implementation class EJBFeedback
 */

@Service
public class EJBFeedback implements FeedbackService {

	@PersistenceContext(unitName="Yop-domain")
	private EntityManager em;
	
    public EJBFeedback() {
        // TODO Auto-generated constructor stub
    }

}
