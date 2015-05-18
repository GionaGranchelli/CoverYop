package it.univaq.mwt.business.impl;

import it.univaq.mwt.business.MessageService;
import it.univaq.mwt.business.model.Conversation;
import it.univaq.mwt.business.model.Message;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EJBMessages implements MessageService {

	@PersistenceContext(unitName = "Yop-domain")
	private EntityManager em;

	public EJBMessages() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Message> findAllMessageByConversationId(int id) {

		Query query = em.createQuery("select ms " + "from Message ms, Conversation cv "
				+ "where cv.id =:id");
		query.setParameter("id", id);
		List<Message> messages = new ArrayList<Message>(query.getResultList());
		return messages;
	}

	@Override
	@Transactional
	public Message createMessage(Message messaggio) {

		Message msg = messaggio;

		em.persist(msg);
		em.getEntityManagerFactory().getCache().evict(Conversation.class);

		return msg;

	}

}
