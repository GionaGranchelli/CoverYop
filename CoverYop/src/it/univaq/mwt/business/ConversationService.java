package it.univaq.mwt.business;

import it.univaq.mwt.business.model.Conversation;



import it.univaq.mwt.business.model.Gruppo;


import it.univaq.mwt.business.model.Message;
import it.univaq.mwt.business.model.Utente;

import java.util.List;
import java.util.Set;

public interface ConversationService {

	public Set<Conversation> findAllConversationByUserId(Utente u);

	List<Conversation> findAllConversationByUserId(int u);

	public Conversation findConversationById(int id);

	public Message createMessage(Message messaggio);
	
	public Conversation updateConversation(Conversation conversation);

	public void refresh(Conversation conversation);

	public Conversation createConversation(Conversation conversation);

	public ResponseGrid<Message> findAllMessagePaginated(RequestGrid requestGrid);
	
}
