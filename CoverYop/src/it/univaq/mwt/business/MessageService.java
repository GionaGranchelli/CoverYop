package it.univaq.mwt.business;

import it.univaq.mwt.business.model.Message;



import java.util.Collection;
import java.util.List;

public interface MessageService {

	public List<Message> findAllMessageByConversationId(int id);

	public Message createMessage(Message messaggio);

	

}
