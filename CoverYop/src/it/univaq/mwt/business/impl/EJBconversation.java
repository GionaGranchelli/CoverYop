package it.univaq.mwt.business.impl;

import it.univaq.mwt.business.ConversationService;
import it.univaq.mwt.business.RequestGrid;
import it.univaq.mwt.business.ResponseGrid;
import it.univaq.mwt.business.model.Conversation;
import it.univaq.mwt.business.model.Message;
import it.univaq.mwt.business.model.Utente;
import it.univaq.mwt.common.utility.ConversionUtility;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EJBconversation implements ConversationService {

	@PersistenceContext(unitName = "Yop-domain")
	private EntityManager em;

	@Override
	public List<Conversation> findAllConversationByUserId(int u) {
		Utente utente = em.getReference(Utente.class, u);
		Query query = em
				.createQuery("select cv "
						+ "from Conversation cv where cv.mittente =:id or cv.destinatario =:idi ORDER BY cv.data DESC ");
		query.setParameter("id", utente);
		query.setParameter("idi", utente);
		List<Conversation> result = (List<Conversation>) query.getResultList();

		return result;
	}

	@Override
	public Set<Conversation> findAllConversationByUserId(Utente u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conversation findConversationById(int id) {
		Conversation conversation = em.find(Conversation.class, id);
		return conversation;
	}

	@Transactional
	public Message createMessage(Message messaggio) {
		Message msg = messaggio;
		// System.out.println(msg.gettext());
		em.persist(msg);
		return msg;
	}

	@Override
	@Transactional
	public Conversation updateConversation(Conversation conversation) {
		Conversation conv = em.merge(conversation);
		return conv;
	}

	@Override
	public void refresh(Conversation conversation) {
		em.refresh(conversation);

	}

	@Transactional
	public Conversation createConversation(Conversation conversation) {
		Conversation cv = conversation;
		em.persist(cv);
		return cv;
	}

	@Override
	public ResponseGrid<Conversation> findAllConversationPaginated(RequestGrid requestGrid, Utente u) {

		String orderBy = (!"".equals(requestGrid.getSortCol()) && !"".equals(requestGrid
				.getSortDir())) ? "ORDER BY " + requestGrid.getSortCol() + " "
				+ requestGrid.getSortDir() : "";
				
		String baseSearch = "SELECT DISTINCT cv "
				+ "FROM Conversation cv "
				+ "WHERE cv.mittente.id =" + u.getId();
		if(!("".equals(requestGrid.getsSearch()))){
			String queryLow = requestGrid.getsSearch().toLowerCase();
			baseSearch = baseSearch + " AND lower(cv.titolo) LIKE '" + ConversionUtility.addPercentSuffix(queryLow)+"'";
		}
		System.out.println("Search Base");
		System.out.println(baseSearch);

//		String countSql = "select count(*) from (" + baseSearch + ")";
		Query query = em.createQuery(baseSearch);
		List<Conversation>result = (List<Conversation>) query.getResultList();
	
		return new ResponseGrid<Conversation>(requestGrid.getsEcho(), result.size(), result.size(), result);
	}
}
