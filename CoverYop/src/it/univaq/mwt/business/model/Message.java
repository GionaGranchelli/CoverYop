package it.univaq.mwt.business.model;

import static javax.persistence.AccessType.PROPERTY;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Access(PROPERTY)
public class Message implements Serializable {
	
	private int id;
	
	private String text;
	
	private Utente autore;
	
	private Calendar dataInvio;
	
	private int status;
	
	private Conversation conversation;

	public Message() {
		super();
	}

	public Message(int id, String text, Utente autore,
			Calendar data, int status, Conversation conversation) {
		super();
		this.id = id;
		this.text = text;
		this.autore = autore;
		this.dataInvio = data;
		this.status = status;
		this.conversation = conversation;
	}

	public Message(String text, Utente autore, Calendar data,
			int status, Conversation conversation) {
		super();
		this.text = text;
		this.autore = autore;
		this.dataInvio = data;
		this.status = status;
		this.conversation = conversation;
	}
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@GeneratedValue(generator="MesSeq")
    @SequenceGenerator(name="MesSeq",sequenceName="MESSAGE_SEQ",allocationSize=1)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String gettext() {
		return text;
	}

	public void settext(String text) {
		this.text = text;
	}
	@OneToOne
	@JoinColumn(name="AUTORE_ID")
	public Utente getAutore() {
		return autore;
	}

	public void setAutore(Utente autore) {
		this.autore = autore;
	}
	@Column(name="DATA")
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getDataInvio() {
		return dataInvio;
	}

	public void setDataInvio(Calendar data) {
		this.dataInvio = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CONVERSATION_ID")
	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}
	
	
	
	

}
