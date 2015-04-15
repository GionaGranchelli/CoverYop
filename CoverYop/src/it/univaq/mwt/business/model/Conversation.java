package it.univaq.mwt.business.model;

import static javax.persistence.AccessType.PROPERTY;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Access;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Access(PROPERTY)
public class Conversation {
	
	private int id;
	
	private Utente mittente;
	
	private Utente destinatario;
	
	private Calendar data;
	
	private int status;
	
	private String titolo;
	
	private List<Message> message = new ArrayList(); 
	
	private static final long serialVersionUID = 1L;

	public Conversation() {
		super();
	}

	public Conversation(Utente mittente, Utente destinatario, Calendar data,
			int status, String titolo) {
		super();
		this.mittente = mittente;
		this.destinatario = destinatario;
		this.data = data;
		this.status = status;
		this.titolo = titolo;
	}







	public Conversation(int id, Utente mittente, Utente destinatario,
			Calendar data, int status, String titolo) {
		super();
		this.id = id;
		this.mittente = mittente;
		this.destinatario = destinatario;
		this.data = data;
		this.status = status;
		this.titolo = titolo;
	}







	public Conversation(Utente mittente, Utente destinatario, Calendar data,
			int status, String titolo, List<Message> message) {
		super();
		this.mittente = mittente;
		this.destinatario = destinatario;
		this.data = data;
		this.status = status;
		this.titolo = titolo;
		this.message = message;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@OneToOne
	@JoinColumn(name="MITTENTE_ID")
	public Utente getMittente() {
		return mittente;
	}
	
	public void setMittente(Utente mittente) {
		this.mittente = mittente;
	}
	@OneToOne
	@JoinColumn(name="DESTINATARIO_ID")
	public Utente getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Utente destinatario) {
		this.destinatario = destinatario;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}







	public String getTitolo() {
		return titolo;
	}







	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}



	@OneToMany(mappedBy="conversation", fetch=FetchType.EAGER , cascade = CascadeType.ALL)
	@OrderBy(value="dataInvio")
	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}
	
	public void addMessage(Message msg){
		this.message.add(msg);
		
	}
	
	
	

}
