package it.univaq.mwt.business;

import it.univaq.mwt.business.model.Message;

import java.util.List;

public interface MessageService {

	List<Message> findAllMessageByConversationId(int id);
	Message createMessage(Message messaggio);
}
