package it.univaq.mwt.presentation;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import it.univaq.mwt.business.ConversationService;
import it.univaq.mwt.business.FotoService;
import it.univaq.mwt.business.GruppoService;
import it.univaq.mwt.business.MessageService;
import it.univaq.mwt.business.UtenteService;
import it.univaq.mwt.business.form.group.FormGruppo;
import it.univaq.mwt.business.form.utente.FormContatta;
import it.univaq.mwt.business.model.Conversation;
import it.univaq.mwt.business.model.Gruppo;
import it.univaq.mwt.business.model.Message;
import it.univaq.mwt.business.model.Utente;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/messages")
public class ControllerMessage {
	@Autowired
	private Utente utente;
	@Autowired 
	UtenteService us;
	@Autowired 
	ConversationService cs;
	@Autowired
	GruppoService gs;
	@Autowired
	MessageService ms;
	@Autowired
	FotoService fs;
	
	
	@RequestMapping("/")
	public String inbox(Model model) throws NamingException {
		
		int id = utente.getId();
		List<Conversation> cl = new ArrayList<Conversation>(cs.findAllConversationByUserId(id));
		model.addAttribute("user", utente);
		model.addAttribute("conversation", cl);	
		model.addAttribute("nuovaconv", new Conversation());
		return "list.conversation";
	}
	
	@RequestMapping("/addconversation")
		public String addConversation(@ModelAttribute("formContatta") FormContatta conversation, BindingResult bindingResult, Model model) throws NamingException {
		
		int id = utente.getId();
		//System.out.println(conversation.getCorpo()+conversation.getTitolo());
		Conversation conv = new Conversation();		
		conv.setTitolo(conversation.getTitolo());
		
		Utente destinatario = us.findUtenteById(conversation.getId());
		conv.setDestinatario(destinatario);
		
		Utente mittente = us.findUtenteById(utente.getId());
		conv.setMittente(mittente);
		
		conv.setData(Calendar.getInstance());
		
		
		Message msg = new Message();
		msg.settext(conversation.getCorpo());
		msg.setAutore(mittente);
		msg.setConversation(conv);
		msg.setDataInvio(Calendar.getInstance());
		msg.setStatus(1);
		conv.addMessage(msg);
		Random rand = new Random();
		int randomNum = rand.nextInt((1000 - 10) + 1) + 10;
		conv.setId(randomNum);
		Conversation cv = cs.createConversation(conv);
		
		List<Conversation> cl = new ArrayList<Conversation>(cs.findAllConversationByUserId(id));
		model.addAttribute("user", utente);
		model.addAttribute("conversation", cl);
		model.addAttribute("nuovaconv", new Conversation());
		
		return "list.conversation";
	}
	
	@RequestMapping("/conversation/{id}")
	public String readConversation(@PathVariable("id") int id, Model model) throws NamingException {
		
		Conversation conversation = cs.findConversationById(id);
		
		model.addAttribute("utente", utente);
		model.addAttribute("conversation", conversation);
		String fotoprofilo2 = null;
		if(utente.getUsername().equals(conversation.getMittente().getUsername())){ 
			model.addAttribute("utente2", conversation.getDestinatario());
			fotoprofilo2 = fs.getFotoProfiloByUtenteId(conversation.getDestinatario().getId());
			System.out.println();
			}
			else {  
				model.addAttribute("utente2", conversation.getMittente());
				fotoprofilo2 = fs.getFotoProfiloByUtenteId(conversation.getMittente().getId());
				System.out.println(fotoprofilo2);
				
			}
		
		
		model.addAttribute("messages", conversation.getMessage());
		String fotoprofilo1 = fs.getFotoProfiloByUtenteId(utente.getId());
		model.addAttribute("fotoprofilo1", fotoprofilo1);
		model.addAttribute("fotoprofilo2", fotoprofilo2);
		model.addAttribute("messaggio", new Message());
		return "show.conversation";
	}
	
	
	
	@RequestMapping("/addreply/{id}")
public String addreply(@PathVariable("id") int id, @ModelAttribute("messaggio") Message messaggio, BindingResult bindingResult, Model model) throws NamingException {
		Conversation conversation = cs.findConversationById(id);
		Calendar cal = Calendar.getInstance(); 
		Utente user = us.findUtenteById(utente.getId());
		messaggio.setAutore(user);		
		messaggio.setConversation(conversation);
		messaggio.setStatus(1);
		messaggio.setDataInvio(cal);
		 Random rand = new Random();
		 int randomNum = rand.nextInt((1000 - 10) + 1) + 10;
		messaggio.setId(randomNum);
		conversation.addMessage(messaggio);
		conversation=cs.updateConversation(conversation);
		//Message msg = ms.createMessage(messaggio);
		System.out.println(messaggio.gettext());
		
//aggiustare refresh della conversazione

		//List<Message> ml = new array(conversation.getMessage());
		model.addAttribute("utente", utente);
		model.addAttribute("conversation", conversation);
		String fotoprofilo2 = null;
		if(utente.getUsername().equals(conversation.getMittente().getUsername())){ 
			model.addAttribute("utente2", conversation.getDestinatario());
			fotoprofilo2 = fs.getFotoProfiloByUtenteId(conversation.getDestinatario().getId());
			}
			else {  
				model.addAttribute("utente2", conversation.getMittente());
				fotoprofilo2 = fs.getFotoProfiloByUtenteId(conversation.getMittente().getId());
				System.out.println(fotoprofilo2);
				
			}
		
		
		model.addAttribute("messages", conversation.getMessage());
		String fotoprofilo1 = fs.getFotoProfiloByUtenteId(utente.getId());
		model.addAttribute("fotoprofilo1", fotoprofilo1);
		model.addAttribute("fotoprofilo2", fotoprofilo2);
		System.out.println(fotoprofilo1+"aaaaaa");
		model.addAttribute("messaggio", new Message());
		return "show.conversation";
	}

}
