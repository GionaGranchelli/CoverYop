package it.univaq.mwt.business;

import it.univaq.mwt.business.model.Conversation;
import it.univaq.mwt.business.model.Message;
import it.univaq.mwt.business.model.Utente;

import java.util.List;
import java.util.Set;

public interface ConversationService {

	Set<Conversation> findAllConversationByUserId(Utente u);
	List<Conversation> findAllConversationByUserId(int u);
	Conversation findConversationById(int id);
	Message createMessage(Message messaggio);
	Conversation updateConversation(Conversation conversation);
	void refresh(Conversation conversation);
	Conversation createConversation(Conversation conversation);
	ResponseGrid<Conversation> findAllConversationPaginated(RequestGrid requestGrid, Utente u);
	
}
